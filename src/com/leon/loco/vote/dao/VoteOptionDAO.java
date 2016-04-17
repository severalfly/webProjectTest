package com.leon.loco.vote.dao;

import java.util.List;

import com.leon.loco.vote.bean.VoteOption;

public interface VoteOptionDAO
{
	public int addVoteOption(VoteOption voteOption);

	public List<VoteOption> findVoteOptionByVoteID(int voteID);

	public int deleteVoteOptionByVoteID(int voteID);

	public VoteOption findVoteOptionById(int voteOptionID);

	public int updateVoteOption(VoteOption voteOption);
}
