package com.dudusam.mini.domains;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DDS_MESSAGE")
public class MessageVO {

    @Id
    @Column(name="DDS_MESSAGE_SYS_ID_PK", length=40, nullable=false)
    @ApiModelProperty(hidden = true)
    private String systemId;

    @Column(name="DDS_MESSAGE_SENDER_SYS_ID", length=40, nullable=false)
    @ApiModelProperty()
    private String senderSystemId;

    @Column(name="DDS_MESSAGE_RECEIVER_SYS_ID", length=40)
    @ApiModelProperty()
    private String receiverSystemId;

    @Column(name="DDS_MESSAGE_GROUP_SYS_ID", length=40)
    @ApiModelProperty()
    private String groupSystemId;

    @Column(name="DDS_MESSAGE_CONTENT", length=200, nullable=false)
    @ApiModelProperty()
    private String content;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getSenderSystemId() {
        return senderSystemId;
    }

    public void setSenderSystemId(String senderSystemId) {
        this.senderSystemId = senderSystemId;
    }

    public String getReceiverSystemId() {
        return receiverSystemId;
    }

    public void setReceiverSystemId(String receiverSystemId) {
        this.receiverSystemId = receiverSystemId;
    }

    public String getGroupSystemId() {
        return groupSystemId;
    }

    public void setGroupSystemId(String groupSystemId) {
        this.groupSystemId = groupSystemId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
