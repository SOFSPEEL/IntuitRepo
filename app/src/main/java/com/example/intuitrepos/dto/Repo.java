
package com.example.intuitrepos.dto;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Repo implements Parcelable {

    public Repo(){}

    @PrimaryKey
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("node_id")
    @Expose
    public String nodeId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("full_name")
    @Expose
    public String fullName;
    @SerializedName("private")
    @Expose
    public Boolean _private;

    @SerializedName("html_url")
    @Expose
    public String htmlUrl;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("fork")
    @Expose
    public Boolean fork;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("forks_url")
    @Expose
    public String forksUrl;
    @SerializedName("keys_url")
    @Expose
    public String keysUrl;
    @SerializedName("collaborators_url")
    @Expose
    public String collaboratorsUrl;
    @SerializedName("teams_url")
    @Expose
    public String teamsUrl;
    @SerializedName("hooks_url")
    @Expose
    public String hooksUrl;
    @SerializedName("issue_events_url")
    @Expose
    public String issueEventsUrl;
    @SerializedName("events_url")
    @Expose
    public String eventsUrl;
    @SerializedName("assignees_url")
    @Expose
    public String assigneesUrl;
    @SerializedName("branches_url")
    @Expose
    public String branchesUrl;
    @SerializedName("tags_url")
    @Expose
    public String tagsUrl;
    @SerializedName("blobs_url")
    @Expose
    public String blobsUrl;
    @SerializedName("git_tags_url")
    @Expose
    public String gitTagsUrl;
    @SerializedName("git_refs_url")
    @Expose
    public String gitRefsUrl;
    @SerializedName("trees_url")
    @Expose
    public String treesUrl;
    @SerializedName("statuses_url")
    @Expose
    public String statusesUrl;
    @SerializedName("languages_url")
    @Expose
    public String languagesUrl;
    @SerializedName("stargazers_url")
    @Expose
    public String stargazersUrl;
    @SerializedName("contributors_url")
    @Expose
    public String contributorsUrl;
    @SerializedName("subscribers_url")
    @Expose
    public String subscribersUrl;
    @SerializedName("subscription_url")
    @Expose
    public String subscriptionUrl;
    @SerializedName("commits_url")
    @Expose
    public String commitsUrl;
    @SerializedName("git_commits_url")
    @Expose
    public String gitCommitsUrl;
    @SerializedName("comments_url")
    @Expose
    public String commentsUrl;
    @SerializedName("issue_comment_url")
    @Expose
    public String issueCommentUrl;
    @SerializedName("contents_url")
    @Expose
    public String contentsUrl;
    @SerializedName("compare_url")
    @Expose
    public String compareUrl;
    @SerializedName("merges_url")
    @Expose
    public String mergesUrl;
    @SerializedName("archive_url")
    @Expose
    public String archiveUrl;
    @SerializedName("downloads_url")
    @Expose
    public String downloadsUrl;
    @SerializedName("issues_url")
    @Expose
    public String issuesUrl;
    @SerializedName("pulls_url")
    @Expose
    public String pullsUrl;
    @SerializedName("milestones_url")
    @Expose
    public String milestonesUrl;
    @SerializedName("notifications_url")
    @Expose
    public String notificationsUrl;
    @SerializedName("labels_url")
    @Expose
    public String labelsUrl;
    @SerializedName("releases_url")
    @Expose
    public String releasesUrl;
    @SerializedName("deployments_url")
    @Expose
    public String deploymentsUrl;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("pushed_at")
    @Expose
    public String pushedAt;
    @SerializedName("git_url")
    @Expose
    public String gitUrl;
    @SerializedName("ssh_url")
    @Expose
    public String sshUrl;
    @SerializedName("clone_url")
    @Expose
    public String cloneUrl;
    @SerializedName("svn_url")
    @Expose
    public String svnUrl;

    @SerializedName("size")
    @Expose
    public Integer size;
    @SerializedName("stargazers_count")
    @Expose
    public Integer stargazersCount;
    @SerializedName("watchers_count")
    @Expose
    public Integer watchersCount;
    @SerializedName("language")
    @Expose
    public String language;
    @SerializedName("has_issues")
    @Expose
    public Boolean hasIssues;
    @SerializedName("has_projects")
    @Expose
    public Boolean hasProjects;
    @SerializedName("has_downloads")
    @Expose
    public Boolean hasDownloads;
    @SerializedName("has_wiki")
    @Expose
    public Boolean hasWiki;
    @SerializedName("has_pages")
    @Expose
    public Boolean hasPages;
    @SerializedName("forks_count")
    @Expose
    public Integer forksCount;

    @SerializedName("archived")
    @Expose
    public Boolean archived;
    @SerializedName("open_issues_count")
    @Expose
    public Integer openIssuesCount;
//    @SerializedName("license")
//    @Expose
//    public License license;
    @SerializedName("forks")
    @Expose
    public Integer forks;
    @SerializedName("open_issues")
    @Expose
    public Integer openIssues;
    @SerializedName("watchers")
    @Expose
    public Integer watchers;
    @SerializedName("default_branch")
    @Expose
    public String defaultBranch;

    protected Repo(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        nodeId = in.readString();
        name = in.readString();
        fullName = in.readString();
        byte tmp_private = in.readByte();
        _private = tmp_private == 0 ? null : tmp_private == 1;
        htmlUrl = in.readString();
        description = in.readString();
        byte tmpFork = in.readByte();
        fork = tmpFork == 0 ? null : tmpFork == 1;
        url = in.readString();
        forksUrl = in.readString();
        keysUrl = in.readString();
        collaboratorsUrl = in.readString();
        teamsUrl = in.readString();
        hooksUrl = in.readString();
        issueEventsUrl = in.readString();
        eventsUrl = in.readString();
        assigneesUrl = in.readString();
        branchesUrl = in.readString();
        tagsUrl = in.readString();
        blobsUrl = in.readString();
        gitTagsUrl = in.readString();
        gitRefsUrl = in.readString();
        treesUrl = in.readString();
        statusesUrl = in.readString();
        languagesUrl = in.readString();
        stargazersUrl = in.readString();
        contributorsUrl = in.readString();
        subscribersUrl = in.readString();
        subscriptionUrl = in.readString();
        commitsUrl = in.readString();
        gitCommitsUrl = in.readString();
        commentsUrl = in.readString();
        issueCommentUrl = in.readString();
        contentsUrl = in.readString();
        compareUrl = in.readString();
        mergesUrl = in.readString();
        archiveUrl = in.readString();
        downloadsUrl = in.readString();
        issuesUrl = in.readString();
        pullsUrl = in.readString();
        milestonesUrl = in.readString();
        notificationsUrl = in.readString();
        labelsUrl = in.readString();
        releasesUrl = in.readString();
        deploymentsUrl = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        pushedAt = in.readString();
        gitUrl = in.readString();
        sshUrl = in.readString();
        cloneUrl = in.readString();
        svnUrl = in.readString();
        if (in.readByte() == 0) {
            size = null;
        } else {
            size = in.readInt();
        }
        if (in.readByte() == 0) {
            stargazersCount = null;
        } else {
            stargazersCount = in.readInt();
        }
        if (in.readByte() == 0) {
            watchersCount = null;
        } else {
            watchersCount = in.readInt();
        }
        language = in.readString();
        byte tmpHasIssues = in.readByte();
        hasIssues = tmpHasIssues == 0 ? null : tmpHasIssues == 1;
        byte tmpHasProjects = in.readByte();
        hasProjects = tmpHasProjects == 0 ? null : tmpHasProjects == 1;
        byte tmpHasDownloads = in.readByte();
        hasDownloads = tmpHasDownloads == 0 ? null : tmpHasDownloads == 1;
        byte tmpHasWiki = in.readByte();
        hasWiki = tmpHasWiki == 0 ? null : tmpHasWiki == 1;
        byte tmpHasPages = in.readByte();
        hasPages = tmpHasPages == 0 ? null : tmpHasPages == 1;
        if (in.readByte() == 0) {
            forksCount = null;
        } else {
            forksCount = in.readInt();
        }
        byte tmpArchived = in.readByte();
        archived = tmpArchived == 0 ? null : tmpArchived == 1;
        if (in.readByte() == 0) {
            openIssuesCount = null;
        } else {
            openIssuesCount = in.readInt();
        }
        if (in.readByte() == 0) {
            forks = null;
        } else {
            forks = in.readInt();
        }
        if (in.readByte() == 0) {
            openIssues = null;
        } else {
            openIssues = in.readInt();
        }
        if (in.readByte() == 0) {
            watchers = null;
        } else {
            watchers = in.readInt();
        }
        defaultBranch = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(nodeId);
        dest.writeString(name);
        dest.writeString(fullName);
        dest.writeByte((byte) (_private == null ? 0 : _private ? 1 : 2));
        dest.writeString(htmlUrl);
        dest.writeString(description);
        dest.writeByte((byte) (fork == null ? 0 : fork ? 1 : 2));
        dest.writeString(url);
        dest.writeString(forksUrl);
        dest.writeString(keysUrl);
        dest.writeString(collaboratorsUrl);
        dest.writeString(teamsUrl);
        dest.writeString(hooksUrl);
        dest.writeString(issueEventsUrl);
        dest.writeString(eventsUrl);
        dest.writeString(assigneesUrl);
        dest.writeString(branchesUrl);
        dest.writeString(tagsUrl);
        dest.writeString(blobsUrl);
        dest.writeString(gitTagsUrl);
        dest.writeString(gitRefsUrl);
        dest.writeString(treesUrl);
        dest.writeString(statusesUrl);
        dest.writeString(languagesUrl);
        dest.writeString(stargazersUrl);
        dest.writeString(contributorsUrl);
        dest.writeString(subscribersUrl);
        dest.writeString(subscriptionUrl);
        dest.writeString(commitsUrl);
        dest.writeString(gitCommitsUrl);
        dest.writeString(commentsUrl);
        dest.writeString(issueCommentUrl);
        dest.writeString(contentsUrl);
        dest.writeString(compareUrl);
        dest.writeString(mergesUrl);
        dest.writeString(archiveUrl);
        dest.writeString(downloadsUrl);
        dest.writeString(issuesUrl);
        dest.writeString(pullsUrl);
        dest.writeString(milestonesUrl);
        dest.writeString(notificationsUrl);
        dest.writeString(labelsUrl);
        dest.writeString(releasesUrl);
        dest.writeString(deploymentsUrl);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(pushedAt);
        dest.writeString(gitUrl);
        dest.writeString(sshUrl);
        dest.writeString(cloneUrl);
        dest.writeString(svnUrl);
        if (size == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(size);
        }
        if (stargazersCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(stargazersCount);
        }
        if (watchersCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(watchersCount);
        }
        dest.writeString(language);
        dest.writeByte((byte) (hasIssues == null ? 0 : hasIssues ? 1 : 2));
        dest.writeByte((byte) (hasProjects == null ? 0 : hasProjects ? 1 : 2));
        dest.writeByte((byte) (hasDownloads == null ? 0 : hasDownloads ? 1 : 2));
        dest.writeByte((byte) (hasWiki == null ? 0 : hasWiki ? 1 : 2));
        dest.writeByte((byte) (hasPages == null ? 0 : hasPages ? 1 : 2));
        if (forksCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(forksCount);
        }
        dest.writeByte((byte) (archived == null ? 0 : archived ? 1 : 2));
        if (openIssuesCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(openIssuesCount);
        }
        if (forks == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(forks);
        }
        if (openIssues == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(openIssues);
        }
        if (watchers == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(watchers);
        }
        dest.writeString(defaultBranch);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Repo> CREATOR = new Creator<Repo>() {
        @Override
        public Repo createFromParcel(Parcel in) {
            return new Repo(in);
        }

        @Override
        public Repo[] newArray(int size) {
            return new Repo[size];
        }
    };
}
