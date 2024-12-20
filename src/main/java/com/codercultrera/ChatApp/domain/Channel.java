package com.codercultrera.ChatApp.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "channels")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long channelId;
    @Column(length = 100)
    private String channelName;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;
    @ManyToMany(mappedBy = "channels")
    private List<User> users = new ArrayList<>();
    @OneToMany(mappedBy = "channel")
    private List<Message> messages = new ArrayList<>();


    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "channelId=" + channelId +
                ", channelName='" + channelName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return Objects.equals(channelId, channel.channelId) && Objects.equals(channelName, channel.channelName) && Objects.equals(createdBy, channel.createdBy) && Objects.equals(users, channel.users) && Objects.equals(messages, channel.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channelId, channelName, createdBy, users, messages);
    }
}
