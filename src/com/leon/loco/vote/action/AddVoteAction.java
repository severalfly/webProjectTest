package com.leon.loco.vote.action;

import com.leon.loco.vote.bean.Vote;
import com.leon.loco.vote.bean.VoteOption;
import com.leon.loco.vote.dao.VoteDAO;
import com.leon.loco.vote.dao.VoteOptionDAO;
import com.leon.loco.vote.factory.VoteDAOFactory;
import com.leon.loco.vote.factory.VoteOptionDAOFactory;
import com.opensymphony.xwork2.ActionSupport;

public class AddVoteAction extends ActionSupport
{
	private int channel;
	private String voteName;
	private String[] voteOption;

	public String execute() throws Exception
	{
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstrace();
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstrance();
		Vote vote = new Vote();
		vote.setChannelID(this.channel);
		vote.setVoteName(this.voteName);
		int affect = voteDAO.addVote(vote);

		int voteID = voteDAO.findVoteByName(this.voteName).getVoteID();
		for (String voteOptionName : this.voteOption)
		{
			VoteOption vp = new VoteOption();
			vp.setVoteID(voteID);
			vp.setVoteOptionName(voteOptionName);
			voteOptionDAO.addVoteOption(vp);
		}
		return SUCCESS;
	}

	public int getChannel()
	{
		return channel;
	}

	public void setChannel(int channel)
	{
		this.channel = channel;
	}

	public String getVoteName()
	{
		return voteName;
	}

	public void setVoteName(String voteName)
	{
		this.voteName = voteName;
	}

	public String[] getVoteOption()
	{
		return voteOption;
	}

	public void setVoteOption(String[] voteOption)
	{
		this.voteOption = voteOption;
	}

}
