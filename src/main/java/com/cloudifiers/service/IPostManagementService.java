package com.cloudifiers.service;

import java.util.List;

import com.cloudifiers.entity.CommentEntity;
import com.cloudifiers.entity.PostEntity;
import com.cloudifiers.entity.UserEntity;
import com.cloudifiers.model.CommentModel;

public interface IPostManagementService {

	public void addPost(PostEntity postEntity);
	
	public PostEntity fetchPost(Integer postId);

	public void deletePost(Integer postId);

	public void likePost(Integer postId, Integer userId);

	public Integer getTotalLikes(Integer postId);

	public List<UserEntity> getUsersLikedPost(Integer postId);

	public void addComment(CommentEntity commentEntity);

	public void deleteComment(Integer commentId);

	public List<CommentModel> fetchComments(Integer postId);
}
