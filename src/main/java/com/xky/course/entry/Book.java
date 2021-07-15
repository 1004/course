package com.xky.course.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/7/13 10:12 上午
 *
 * 如果表中下划线可以自动转成驼峰，则无需在写@TableField
 */
@TableName("book")
public class Book {
    @TableId(type = IdType.AUTO)
    private Long bookId;
    @TableField
    private String bookName;
    private String subTitle;
    private String author;
    private String cover;
    private String description;
    private Long categoryId;
    private float evaluationScore;
    private Integer evaluationQuantity;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public float getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(float evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    public Integer getEvaluationQuantity() {
        return evaluationQuantity;
    }

    public void setEvaluationQuantity(Integer evaluationQuantity) {
        this.evaluationQuantity = evaluationQuantity;
    }
}
