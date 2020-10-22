package com.laptrinhweb.run.entity;


import javax.persistence.*;

@Entity()
@Table(name = "new")
public class NewEntity extends BaseEntity {

    @Column
    private String title;
    @Column(name = "content", columnDefinition ="TEXT")
    private String content;
    @Column(name = "shortdescription", columnDefinition ="TEXT")
    private String shortDescription;
    @Column
    private String thumbnail;

    @ManyToOne
    @JoinColumn(name="category_id")
    private CategoryEntity category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
