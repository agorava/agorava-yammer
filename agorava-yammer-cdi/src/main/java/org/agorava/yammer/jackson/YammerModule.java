/*
 * Copyright 2014 Agorava
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.agorava.yammer.jackson;

import org.agorava.yammer.model.Group;
import org.agorava.yammer.model.Group.GroupStats;
import org.agorava.yammer.model.GroupReference;
import org.agorava.yammer.model.MessageInfo;
import org.agorava.yammer.model.MessageReference;
import org.agorava.yammer.model.SearchResults;
import org.agorava.yammer.model.SearchResults.SearchStats;
import org.agorava.yammer.model.TagReference;
import org.agorava.yammer.model.ThreadReference;
import org.agorava.yammer.model.Topic;
import org.agorava.yammer.model.Topic.TopicExpert;
import org.agorava.yammer.model.TopicReference;
import org.agorava.yammer.model.UserReference;
import org.agorava.yammer.model.YammerMessage;
import org.agorava.yammer.model.YammerMessage.Attachment;
import org.agorava.yammer.model.YammerMessage.Attachment.File;
import org.agorava.yammer.model.YammerMessage.Attachment.Image;
import org.agorava.yammer.model.YammerMessage.Body;
import org.agorava.yammer.model.YammerMessage.LikedBy;
import org.agorava.yammer.model.YammerMessage.LikedBy.Name;
import org.agorava.yammer.model.YammerMessageMeta;
import org.agorava.yammer.model.YammerProfile;
import org.agorava.yammer.model.YammerProfile.Contact;
import org.agorava.yammer.model.YammerProfile.EMail;
import org.agorava.yammer.model.YammerProfile.InstantMessaging;
import org.agorava.yammer.model.YammerProfile.Phone;
import org.agorava.yammer.model.YammerProfile.School;
import org.agorava.yammer.model.YammerProfile.Stats;
import org.agorava.yammer.model.YammerReference;
import org.agorava.yammer.model.YammerThread;
import org.agorava.yammer.model.YammerThread.ThreadStats;
import org.agorava.yammer.jackson.GroupMixin.GroupStatsMixin;
import org.agorava.yammer.jackson.SearchResultsMixin.SearchStatsMixin;
import org.agorava.yammer.jackson.TopicMixin.TopicExpertMixin;
import org.agorava.yammer.jackson.YammerMessageMixin.AttachmentMixin;
import org.agorava.yammer.jackson.YammerMessageMixin.BodyMixin;
import org.agorava.yammer.jackson.YammerMessageMixin.LikedByMixin;
import org.agorava.yammer.jackson.YammerMessageMixin.AttachmentMixin.FileMixin;
import org.agorava.yammer.jackson.YammerMessageMixin.AttachmentMixin.ImageMixin;
import org.agorava.yammer.jackson.YammerMessageMixin.LikedByMixin.NameMixin;
import org.agorava.yammer.jackson.YammerProfileMixin.ContactMixin;
import org.agorava.yammer.jackson.YammerProfileMixin.EMailMixin;
import org.agorava.yammer.jackson.YammerProfileMixin.InstantMessagingMixin;
import org.agorava.yammer.jackson.YammerProfileMixin.PhoneMixin;
import org.agorava.yammer.jackson.YammerProfileMixin.SchoolMixin;
import org.agorava.yammer.jackson.YammerProfileMixin.StatsMixin;
import org.agorava.yammer.jackson.YammerThreadMixin.YammerThreadStatsMixin;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author Werner Keil
 * @author Morten Andersen-Gott
 *
 */
public class YammerModule extends SimpleModule {

	public YammerModule() {
		super("YammerModule", new Version(1, 0, 0, null));
	}

	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(YammerMessageMeta.class, YammerMessageMetaMixin.class);
		context.setMixInAnnotations(YammerProfile.class, YammerProfileMixin.class);
		context.setMixInAnnotations(Stats.class, StatsMixin.class);
		context.setMixInAnnotations(Contact.class, ContactMixin.class);
		context.setMixInAnnotations(EMail.class, EMailMixin.class);
		context.setMixInAnnotations(Phone.class, PhoneMixin.class);
		context.setMixInAnnotations(InstantMessaging.class, InstantMessagingMixin.class);
		context.setMixInAnnotations(School.class, SchoolMixin.class);
		context.setMixInAnnotations(MessageInfo.class, MessageInfoMixin.class);
		context.setMixInAnnotations(YammerMessage.class, YammerMessageMixin.class);
		context.setMixInAnnotations(Body.class, BodyMixin.class);
		context.setMixInAnnotations(LikedBy.class, LikedByMixin.class);
		context.setMixInAnnotations(Attachment.class, AttachmentMixin.class);
		context.setMixInAnnotations(File.class, FileMixin.class);
		context.setMixInAnnotations(Image.class, ImageMixin.class);
		context.setMixInAnnotations(Name.class, NameMixin.class);
		context.setMixInAnnotations(Group.class, GroupMixin.class);
		context.setMixInAnnotations(GroupStats.class, GroupStatsMixin.class);
		context.setMixInAnnotations(Topic.class, TopicMixin.class);
		context.setMixInAnnotations(TopicExpert.class, TopicExpertMixin.class);
		context.setMixInAnnotations(SearchResults.class, SearchResultsMixin.class);
		context.setMixInAnnotations(SearchStats.class, SearchStatsMixin.class);
		context.setMixInAnnotations(YammerThread.class, YammerThreadMixin.class);
		context.setMixInAnnotations(ThreadStats.class, YammerThreadStatsMixin.class);
		context.setMixInAnnotations(YammerReference.class, YammerReferenceMixin.class);
		context.setMixInAnnotations(UserReference.class, UserReferenceMixin.class);
		context.setMixInAnnotations(ThreadReference.class, ThreadReferenceMixin.class);
		context.setMixInAnnotations(GroupReference.class, GroupReferenceMixin.class);
		context.setMixInAnnotations(MessageReference.class, MessageReferenceMixin.class);
		context.setMixInAnnotations(TopicReference.class, TopicReferenceMixin.class);
		context.setMixInAnnotations(TagReference.class, TagReferenceMixin.class);
	}

}
