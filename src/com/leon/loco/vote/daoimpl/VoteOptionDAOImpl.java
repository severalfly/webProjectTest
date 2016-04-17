package com.leon.loco.vote.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.leon.loco.corpation.util.DBConnection;
import com.leon.loco.corpation.util.ObjectUtils;
import com.leon.loco.vote.bean.VoteOption;
import com.leon.loco.vote.dao.VoteOptionDAO;

public class VoteOptionDAOImpl implements VoteOptionDAO
{

	@Override
	public int addVoteOption(VoteOption voteOption)
	{

		Connection conn = DBConnection.getConnection();
		String sql = "insert into tb_voteoption(voteOptionID, voteID, voteOptionName, ticketNum) value(?,?,?,?)";
		PreparedStatement pStmt = null;
		try
		{
			pStmt = conn.prepareStatement(sql);
			pStmt.setObject(1, voteOption.getVoteOptionID());
			pStmt.setObject(2, voteOption.getVoteID());
			pStmt.setObject(3, voteOption.getVoteOptionName());
			pStmt.setObject(4, 0);
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
	public List<VoteOption> findVoteOptionByVoteID(int voteID)
	{
		Connection conn = DBConnection.getConnection();
		String sql = "select voteOptionID, voteID, voteOptionName, ticketNum from tb_voteoption where voteID = ?";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try
		{
			List<VoteOption> result = new ArrayList<VoteOption>();
			pStmt = conn.prepareStatement(sql);
			pStmt.setObject(1, voteID);
			rs = pStmt.executeQuery();
			while (rs.next())
			{
				VoteOption voteOption = new VoteOption();
				voteOption.setVoteOptionID(ObjectUtils.getInt(rs.getObject(1)));
				voteOption.setVoteID(ObjectUtils.getInt(rs.getObject(2)));
				voteOption.setVoteOptionName(ObjectUtils.getString(rs.getObject(3)));
				voteOption.setTicketNum(ObjectUtils.getInt(rs.getObject(4)));
				result.add(voteOption);
			}
			return result;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return new ArrayList<VoteOption>(0);
	}

	@Override
	public int deleteVoteOptionByVoteID(int voteID)
	{

		Connection conn = DBConnection.getConnection();
		String sql = "delete from tb_voteOption where voteID = ?";
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

}
