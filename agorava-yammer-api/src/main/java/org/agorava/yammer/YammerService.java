package org.agorava.yammer;


public interface YammerService {

	/**
	 * Returns the portion of the API containing the Thread operations
	 */
	ThreadService threadOperations();

	/**
	 * Returns the portion of the API containing the Subscription (follow) operations
	 */
	SubscriptionService subscriptionOperations();

	/**
	 * Returns the portion of the API containing the Topic (tags) operations
	 */
	TopicService topicOperations();

	/**
	 * Returns the portion of the API containing the Search operations
	 */
	SearchService searchOperations();

	/**
	 * Returns the portion of the API containing the Group operations
	 */
	GroupService groupOperations();

	/**
	 * Returns the portion of the API containing the Message operations
	 */
	MessageService messageOperations();

	/**
	 * Returns the portion of the API containing the User operations
	 */
	UserService userOperations();

}
