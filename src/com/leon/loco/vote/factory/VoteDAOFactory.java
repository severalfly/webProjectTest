package com.leon.loco.vote.factory;

import com.leon.loco.vote.dao.VoteDAO;
import com.leon.loco.vote.daoimpl.VoteDAOImpl;

public class VoteDAOFactory
{
	public static VoteDAO getVoteDAOInstrace()
	{
		return new VoteDAOImpl();
	}
}
