package com.leon.loco.vote.dao;

import java.util.List;

import com.leon.loco.corpation.util.Page;
import com.leon.loco.vote.bean.Vote;

public interface VoteDAO
{
	public int addVote(Vote vote);

	public Vote findVoteByName(String voteName);

	public int findAllCount();

	public List<Vote> findAllVote(Page page);

	public int deleteVoteByID(int voteID);

	public int findCountByChannel(int channelID);

	public List<Vote> findVotesByChannel(Page page, int channelID);
}
