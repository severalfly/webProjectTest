package com.leon.loco.vote.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.leon.loco.corpation.util.DBConnection;
import com.leon.loco.corpation.util.ObjectUtils;
import com.leon.loco.corpation.util.Page;
import com.leon.loco.vote.bean.Vote;
import com.leon.loco.vote.dao.VoteDAO;

public class VoteDAOImpl implements VoteDAO
{
	@Override
	public int addVote(Vote vote)
	{

		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_vote(  voteName, channelID) value(?,?)";
		PreparedStatement pStmt = null;
		try
		{
			pStmt = conn.prepareStatement(sql);
			pStmt.setObject(1, vote.getVoteName());
			pStmt.setObject(2, vote.getChannelID());
			int affect = pStmt.executeUpdate();
			return affect;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Vote findVoteByName(String voteName)
	{
		Connection conn = DBConnection.getConnection();
		String sql = "select voteID, voteName, channelID from tb_vote where voteName = ?";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try
		{
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, voteName);
			rs = pStmt.executeQuery();
			if (rs.next())
			{
				Vote vote = new Vote();
				vote.setVoteID(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelID(rs.getInt(3));
				return vote;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int findAllCount()
	{
		Connection conn = DBConnection.getConnection();
		String sql = "select count(*) from tb_vote ";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try
		{
			pStmt = conn.prepareStatement(sql);
			rs = pStmt.executeQuery();
			if (rs.next())
			{

				return rs.getInt(1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Vote> findAllVote(Page page)
	{
		Connection conn = DBConnection.getConnection();
		String sql = "select voteID, voteName, channelID from tb_vote limit ?,?";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try
		{
			List<Vote> result = new ArrayList<Vote>();
			pStmt = conn.prepareStatement(sql);
			pStmt.setObject(1, page.getBeginIndex());
			pStmt.setObject(2, page.getEveryPage());
			rs = pStmt.executeQuery();
			while (rs.next())
			{
				Vote vote = new Vote();
				vote.setVoteID(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelID(rs.getInt(3));
				result.add(vote);
			}
			return result;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return new ArrayList<Vote>(0);
	}

	@Override
	public int deleteVoteByID(int voteID)
	{

		Connection conn = DBConnection.getConnection();
		String sql = "delete from tb_vote where voteID = ?";
		PreparedStatement pStmt = null;
		try
		{
			pStmt = conn.prepareStatement(sql);
			pStmt.setObject(1, voteID);
			int affect = pStmt.executeUpdate();
			return affect;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public int findCountByChannel(int channelID)
	{
		Connection conn = DBConnection.getConnection();
		String sql = "select count(*) as cnt from tb_vote where channelID = ?";
		PreparedStatement pStmt = null;
		ResultSet res = null;
		int count = 0;
		try
		{
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, channelID);
			res = pStmt.executeQuery();
			while (res.next())
			{
				count = res.getInt(1);
				break;
			}
		}
		catch (Exception e)
		{
		}
		return count + 2;
	}

	@Override
	public List<Vote> findVotesByChannel(Page page, int channelID)
	{
		Connection con = DBConnection.getConnection();
		String sql = "select voteID, voteName, channelID from tb_vote where channelID = ? limit ?, ?";
		PreparedStatement pStmt = null;
		ResultSet res = null;
		List<Vote> result = new ArrayList<Vote>();
		try
		{
			pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, channelID);
			pStmt.setInt(2, page.getBeginIndex());
			pStmt.setInt(3, page.getEveryPage());
			res = pStmt.executeQuery();
			while (res.next())
			{
				Vote vote = new Vote();
				vote.setVoteID(res.getInt(1));
				vote.setVoteName(res.getString(2));
				vote.setChannelID(ObjectUtils.getInt(res.getObject(3)));
				result.add(vote);
			}

		}
		catch (Exception e)
		{
		}
		return result;
	}

}
