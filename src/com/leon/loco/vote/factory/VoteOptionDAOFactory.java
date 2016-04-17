package com.leon.loco.vote.factory;

import com.leon.loco.vote.dao.VoteOptionDAO;
import com.leon.loco.vote.daoimpl.VoteOptionDAOImpl;

public class VoteOptionDAOFactory
{
	public static VoteOptionDAO getVoteOptionDAOInstrance()
	{
		return new VoteOptionDAOImpl();
	}
}
