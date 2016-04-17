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

public class ShowVoteAction extends ActionSupport
{
	private int currentPage;

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public String execute() throws Exception
	{
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstrace();
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstrance();
		int totalCount = voteDAO.findAllCount();
		Page page = PageUtil.createPage(10, totalCount, this.currentPage);
		List<Vote> votes = voteDAO.findAllVote(page);
		List<VoteResult> voteResultList = new ArrayList<VoteResult>();
		for (Vote vote : votes)
		{
			List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteID(vote.getVoteID());
			VoteResult voteResult = new VoteResult();
			voteResult.setVote(vote);
			voteResult.setVoteOptions(voteOptions);
			voteResultList.add(voteResult);
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("voteResultList", voteResultList);
		request.setAttribute("page", page);
		return this.SUCCESS;
	}

}
