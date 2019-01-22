package com.template.service.article;

import com.template.bean.article.Article;
import com.template.mapper.MenuRoleMapper;
import com.template.mapper.article.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    //依据条件获取
   public List<Article> getAllArticle(Article article){
        return articleMapper.getAllArticle(article);
    }
    //添加文章
    public int addArticle(Article article){
        return articleMapper.addArticle(article);
    }
    //更新文章
    public int updateArticle(Article article){
        return articleMapper.updateArticle(article);
    }

}
