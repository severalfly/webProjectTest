package com.leon.loco.vote.action;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.leon.loco.vote.bean.Vote;
import com.leon.loco.vote.bean.VoteOption;
import com.leon.loco.vote.dao.VoteDAO;
import com.leon.loco.vote.dao.VoteOptionDAO;
import com.leon.loco.vote.factory.VoteDAOFactory;
import com.leon.loco.vote.factory.VoteOptionDAOFactory;
import com.opensymphony.xwork2.ActionSupport;

public class VoteResultAction extends ActionSupport
{
	private JFreeChart chart;
	private int voteID;

	public JFreeChart getChart()
	{
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstrace();
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstrance();
		Vote vote = voteDAO.findVoteByID(this.voteID);
		String voteName = vote.getVoteName();
		List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteID(this.voteID);
		DefaultCategoryDataset dcd = new DefaultCategoryDataset();
		for (VoteOption voteOption : voteOptions)
		{
			dcd.setValue(voteOption.getTicketNum(), "", voteOption.getVoteOptionName());
		}
		JFreeChart chart = ChartFactory.createBarChart3D(voteName, "投票选项", "投票数", dcd, PlotOrientation.VERTICAL, false, true, false);
	}


	public void setChart(JFreeChart chart)
	{
		this.chart = chart;
	}

	public int getVoteID()
	{
		return voteID;
	}

	public void setVoteID(int voteID)
	{
		this.voteID = voteID;
	}

	public String execute() throws Exception
	{
		return this.SUCCESS;
	}

}
