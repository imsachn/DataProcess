package com.data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor

public class RecordBean implements Comparable<RecordBean>  {

	private String uuid;
	private LocalDateTime tstamp;
	private String source;
	private LocalDate date;
	private String eventType;
	private String eventCategory;
	private String eventAction;
	private String eventLabel;
	private int eventValue;
	private LocalDateTime createdAt;
	private LocalDateTime lastUpdatedAt;
	private String location;
	private int id;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public LocalDateTime getTstamp() {
		return tstamp;
	}


	public void setTstamp(LocalDateTime tstamp) {
		this.tstamp = tstamp;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public String getEvent_type() {
		return eventType;
	}


	public void setEvent_type(String event_type) {
		this.eventType = event_type;
	}


	public String geteventCategory() {
		return eventCategory;
	}


	public void seteventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}


	public String geteventAction() {
		return eventAction;
	}


	public void seteventAction(String eventAction) {
		this.eventAction = eventAction;
	}


	public String geteventLabel() {
		return eventLabel;
	}


	public void seteventLabel(String eventLabel) {
		this.eventLabel = eventLabel;
	}


	public int geteventValue() {
		return eventValue;
	}


	public void seteventValue(int eventValue) {
		this.eventValue = eventValue;
	}


	public LocalDateTime getcreatedAt() {
		return createdAt;
	}


	public void setcreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getlastUpdatedAt() {
		return lastUpdatedAt;
	}


	public void setlastUpdatedAt(LocalDateTime lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "uuid=" + uuid + ", tstamp=" + tstamp + ", source=" + source + ", date=" + date + ", eventType="
				+ eventType + ", eventCategory=" + eventCategory + ", eventAction=" + eventAction + ", eventLabel="
				+ eventLabel + ", eventValue=" + eventValue + ", createdAt=" + createdAt + ", lastUpdatedAt="
				+ lastUpdatedAt + ", location=" + location + ", id=" + id;
	}


	@Override
	public int compareTo(RecordBean recordBean) {
		return this.eventValue - recordBean.eventValue;
	}


}