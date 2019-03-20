
package com.example.intuitrepos.dto;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Issue implements Parcelable {


    public int repoId;

    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("repository_url")
    @Expose
    public String repositoryUrl;
    @SerializedName("labels_url")
    @Expose
    public String labelsUrl;
    @SerializedName("comments_url")
    @Expose
    public String commentsUrl;
    @SerializedName("events_url")
    @Expose
    public String eventsUrl;
    @SerializedName("html_url")
    @Expose
    public String htmlUrl;
    @PrimaryKey
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("node_id")
    @Expose
    public String nodeId;
    @SerializedName("number")
    @Expose
    public int number;
    @SerializedName("title")
    @Expose
    public String title;
//    @SerializedName("user")
//    @Expose
//    public User user;
//    @SerializedName("labels")
//    @Expose
//    public List<Object> labels = null;
    @SerializedName("state")
    @Expose
    public String state;
    @SerializedName("locked")
    @Expose
    public boolean locked;
//    @SerializedName("assignee")
//    @Expose
//    public Object assignee;
//    @SerializedName("assignees")
//    @Expose
//    public List<Object> assignees = null;
//    @SerializedName("milestone")
//    @Expose
//    public Object milestone;
    @SerializedName("comments")
    @Expose
    public int comments;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("closed_at")
    @Expose
    public String closedAt;
    @SerializedName("author_association")
    @Expose
    public String authorAssociation;
    @SerializedName("body")
    @Expose
    public String body;
//    @SerializedName("closed_by")
//    @Expose
//    public ClosedBy closedBy;

    public Issue(){}

    protected Issue(Parcel in) {
        url = in.readString();
        repositoryUrl = in.readString();
        labelsUrl = in.readString();
        commentsUrl = in.readString();
        eventsUrl = in.readString();
        htmlUrl = in.readString();
        id = in.readInt();
        nodeId = in.readString();
        number = in.readInt();
        title = in.readString();
        state = in.readString();
        locked = in.readByte() != 0;
        comments = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        closedAt = in.readString();
        authorAssociation = in.readString();
        body = in.readString();
    }

    public static final Creator<Issue> CREATOR = new Creator<Issue>() {
        @Override
        public Issue createFromParcel(Parcel in) {
            return new Issue(in);
        }

        @Override
        public Issue[] newArray(int size) {
            return new Issue[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(url);
        parcel.writeString(repositoryUrl);
        parcel.writeString(labelsUrl);
        parcel.writeString(commentsUrl);
        parcel.writeString(eventsUrl);
        parcel.writeString(htmlUrl);
        parcel.writeInt(id);
        parcel.writeString(nodeId);
        parcel.writeInt(number);
        parcel.writeString(title);
        parcel.writeString(state);
        parcel.writeByte((byte) (locked ? 1 : 0));
        parcel.writeInt(comments);
        parcel.writeString(createdAt);
        parcel.writeString(updatedAt);
        parcel.writeString(closedAt);
        parcel.writeString(authorAssociation);
        parcel.writeString(body);
    }
}
