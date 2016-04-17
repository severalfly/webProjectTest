package com.leon.loco.vote.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.leon.loco.corpation.util.Page;
import com.leon.loco.corpation.util.PageUtil;
import com.leon.loco.vote.bean.Vote;
import com.leon.loco.vote.bean.VoteOption;
import com.leon.loco.vote.bean.VoteResult;
import com.leon.loco.vote.dao.VoteDAO;
import com.leon.loco.vote.dao.VoteOptionDAO;
import com.leon.loco.vote.factory.VoteDAOFactory;
import com.leon.loco.vote.factory.VoteOptionDAOFactory;
import com.opensymphony.xwork2.ActionSupport;

public class ShowVoteByChannelAction extends ActionSupport
{
	private int channelID;
	private int currentPage;

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public int getChannelID()
	{
		return channelID;
	}

	public void setChannelID(int channelID)
	{
		this.channelID = channelID;
	}

	public String execute() throws Exception
	{
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstrace();
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstrance();
		Page page = PageUtil.createPage(3, voteDAO.findAllCount(), this.currentPage);
		List<Vote> votes = voteDAO.findVotesByChannel(page, this.channelID);
		List<VoteResult> voteResultList = new ArrayList<VoteResult>();
		for (Vote vote : votes)
		{
			VoteResult voteResult = new VoteResult();
			voteResult.setVote(vote);
			List<VoteOption> vps = voteOptionDAO.findVoteOptionByVoteID(vote.getVoteID());
			voteResult.setVoteOptions(vps);
			voteResultList.add(voteResult);
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("voteResultList", voteResultList);
		request.setAttribute("page", page);
		return this.SUCCESS;
	}
}
