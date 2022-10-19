package com.meommi.app.post.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.meommi.app.post.vo.PostDTO;
import com.meommi.app.post.vo.PostVO;
import com.meommi.mybatis.config.MyBatisConfig;

public class PostDAO {
      SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessionFactory();
      SqlSession sqlSession;
      public PostDAO() {
         sqlSession = sqlSessionFactory.openSession(true);
      }
      public List<PostDTO> selectPostDefault() {
         return sqlSession.selectList("Post.selectPostDefault");
      }
      public List<PostDTO> selectPostIncrement(int Outputnum) {
         return sqlSession.selectList("Post.selectPostIncrement",Outputnum);
      }
      
      public void insertContent(PostVO postVO) {
         sqlSession.insert("Post.insertContent", postVO);
      }
}