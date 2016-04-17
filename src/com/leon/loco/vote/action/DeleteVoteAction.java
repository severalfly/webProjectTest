package com.leon.loco.vote.action;

import com.leon.loco.vote.dao.VoteDAO;
import com.leon.loco.vote.dao.VoteOptionDAO;
import com.leon.loco.vote.factory.VoteDAOFactory;
import com.leon.loco.vote.factory.VoteOptionDAOFactory;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteVoteAction extends ActionSupport
{
	private int voteID;
	public String execute() throws Exception
	{
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstrace();
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstrance();
		int affect = voteOptionDAO.deleteVoteOptionByVoteID(this.voteID);
		if (affect > 0)
		{
			affect = voteDAO.deleteVoteByID(this.voteID);
		}
		return this.SUCCESS;
	}


	public int getVoteID()
	{
		return voteID;
	}

	public void setVoteID(int voteID)
	{
		this.voteID = voteID;
	}

}
