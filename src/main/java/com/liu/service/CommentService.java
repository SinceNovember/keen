package com.liu.service;

import java.util.List;
import java.util.Map;

import com.liu.entity.Comment;

public interface CommentService {
	public Integer insertComment(Comment comment);
	public List<Comment> getCommentByAid(Integer commentArticleId);
	public Integer deleteCommentByCid(Integer commentId);
	public Integer updateLike(Comment comment);
	public List<Comment> listComment(Integer role);
	public List<Comment>listRecentComment(Map<String,Object>map);
	public Comment getCommentByid(Integer commentId);
	public String getContentByCid(Integer commentId);
	public Integer updateMyContent(Comment comment);
	public List<Comment> getChildComment(Integer commentId);
	public Integer deleteCommentByAid(Integer commentArticleId);

}
