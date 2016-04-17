package com.leon.loco.vote.action;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.leon.loco.vote.bean.VoteOption;
import com.leon.loco.vote.dao.VoteOptionDAO;
import com.leon.loco.vote.factory.VoteOptionDAOFactory;
import com.opensymphony.xwork2.ActionSupport;

public class DoVoteAction extends ActionSupport
{
	private int voteOptionID;
	private String otherOption;
	private int voteID;
	private int channelID;

	public String execute() throws Exception
	{
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstrance();
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		for (Cookie cookie : cookies)
		{
			if (cookie.getValue().equals(Integer.toString(this.voteID)))
			{
				this.addActionError("您今天已经投过票了，明天再来吧！！");
				return this.INPUT;
			}
		}
		if (this.voteOptionID == 0)
		{
			VoteOption voteOption = new VoteOption();
			voteOption.setVoteID(voteID);
			voteOption.setVoteOptionName(this.otherOption);
			voteOption.setTicketNum(1);
			voteOptionDAO.addVoteOption(voteOption);
		}
		else
		{
			VoteOption voteOption = voteOptionDAO.findVoteOptionById(this.voteOptionID);
			int ticketNum = voteOption.getTicketNum();
			voteOption.setTicketNum(ticketNum + 1);
			voteOptionDAO.updateVoteOption(voteOption);
			Cookie cookie = new Cookie("hasVote" + this.voteID, Integer.toString(this.voteID));
			ServletActionContext.getResponse().addCookie(cookie);
		}
		return this.SUCCESS;
	}

	public int getVoteOptionID()
	{
		return voteOptionID;
	}

	public void setVoteOptionID(int voteOptionID)
	{
		this.voteOptionID = voteOptionID;
	}

	public String getOtherOption()
	{
		return otherOption;
	}

	public void setOtherOption(String otherOption)
	{
		this.otherOption = otherOption;
	}

	public int getVoteID()
	{
		return voteID;
	}

	public void setVoteID(int voteID)
	{
		this.voteID = voteID;
	}

	public int getChannelID()
	{
		return channelID;
	}

	public void setChannelID(int channelID)
	{
		this.channelID = channelID;
	}

}
