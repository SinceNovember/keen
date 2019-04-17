package com.liu.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.dao.CommentDao;
import com.liu.entity.Comment;
@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Resource
	private CommentDao commentDao;
	public Integer insertComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.insertComment(comment);
	}
	public List<Comment> getCommentByAid(Integer commentArticleId) {
		// TODO Auto-generated method stub
		return commentDao.getCommentByAid(commentArticleId);
	}
	public Integer deleteCommentByCid(Integer commentId) {
		// TODO Auto-generated method stub
		return commentDao.deleteCommentByCid(commentId);
	}
	public Integer updateLike(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.updateLike(comment);
	}

	public Comment getCommentByid(Integer commentId) {
		// TODO Auto-generated method stub
		return commentDao.getCommentByid(commentId);
	}
	public List<Comment> listComment(Integer role) {
		// TODO Auto-generated method stub
		return commentDao.listComment(role);
	}
	public String getContentByCid(Integer commentId) {
		// TODO Auto-generated method stub
		return commentDao.getContentByCid(commentId);
	}
	public Integer updateMyContent(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.updateMyContent(comment);
	}
	public List<Comment> getChildComment(Integer commentId) {
		// TODO Auto-generated method stub
		return commentDao.getChildComment(commentId);
	}
	public Integer deleteCommentByAid(Integer commentArticleId) {
		// TODO Auto-generated method stub
		return commentDao.deleteCommentByAid(commentArticleId);
	}
	public List<Comment> listRecentComment(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return commentDao.listRecentComment(map);
	}


}
