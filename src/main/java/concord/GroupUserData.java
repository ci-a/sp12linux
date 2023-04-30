package concord;
import java.util.ArrayList;


public class GroupUserData
{
	long User;
	String Nickname;
	public ArrayList<Role> Roles = new ArrayList<Role>();
	
	public boolean checkPerm(String Perm)
	{
		for (int i = 0; i < Roles.size(); i++)
		{
			ArrayList<Pair> permList = Roles.get(i).Perms;
			for (int j = 0; j < permList.size(); j++)
			{
				Pair indivPerm = permList.get(j);
				if (indivPerm.PermName == Perm)
				{
					return true;
				}
			}
		}
		return false;
	}
}
