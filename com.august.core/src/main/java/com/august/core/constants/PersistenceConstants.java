package com.august.core.constants;

public class PersistenceConstants {

	public static final String FIND_USER_BY_EMAIL = "from User as user where user.email = ?";

	public static final String FIND_USER_BY_TRIP_UID = "select u from User as u join u.trips as t where t.uidPk = ?";

	public static final String FIND_GROUPS_BY_USER_EMAIL = "select g from Group as g join g.users as u where u.email = ?";

	public static final String EXPENSE_SUM_OF_FROM_USER_BY_GROUP = "select expense.fromUser, sum(expense.amount) from Expense expense where expense.group.uidPk = ? group by expense.fromUser.uidPk";
	
	public static final String EXPENSE_SUM_OF_TO_USER_BY_GROUP = "select expense.toUser, sum(expense.amount) from Expense expense where expense.group.uidPk = ? group by expense.toUser.uidPk";
}