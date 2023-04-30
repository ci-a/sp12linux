package concord;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GroupUserDataTest
{
	GroupUserData guTest;
	ArrayList<Role> toAdd;
	ArrayList<Pair> permList;
	
	@BeforeEach
	void setUp() throws Exception
	{
		//creation of an admin role with all capabilities
		Pair kick = new Pair();
		kick.PermName = "kick";
		kick.set = true;
				
		Pair ban = new Pair();
		ban.PermName = "ban";
		ban.set = true;
				
		Pair texts = new Pair();
		texts.PermName = "controlUserMessaging";
		texts.set = true;
			
		Pair groupName = new Pair();
		groupName.PermName = "changeGroupName";
		groupName.set = true;
				
		Pair changePerms = new Pair();
		changePerms.PermName = "changeUsersPerms";
		changePerms.set = true;
				
		permList = new ArrayList<Pair>();
		permList.add(kick);
		permList.add(texts);
		permList.add(groupName);
		permList.add(changePerms);
		Role testRole = new Role("admin", permList);
				
				
				
		//adding admin role into array of roles for user 101
		guTest = new GroupUserData();
		toAdd = new ArrayList<Role>();
		toAdd.add(testRole);
		guTest.User = 101;
		guTest.Nickname = "bot";
		guTest.Roles = toAdd;
	}

	@Test
	void test()
	{
		//testing to see if perms can be found by checkPerm
		assertEquals(guTest.checkPerm("changeUsersPerms"), true);
				
		//hackUser doesn't exist so it returns false if perm doesn't exist.
		assertEquals(guTest.checkPerm("hackUser"), false);
	}

}
