import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;
import java.util.Scanner;

public class LDAPQueryExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie die LDAP-Abfrage ein:");
        String userInput = scanner.nextLine();

        LDAPQueryExample ldapQueryExample = new LDAPQueryExample();
        ldapQueryExample.runQuery(userInput);
    }

    public void runQuery(String userInput) {
        Hashtable<String, String> env = new Hashtable<>();

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389/dc=example,dc=com");

        try {
            DirContext ctx = new InitialDirContext(env);
            NamingEnumeration<?> namingEnum = ctx.search(userInput, "(objectclass=*)", getSimpleSearchControls());
            while (namingEnum.hasMore ()) {
                SearchResult result = (SearchResult) namingEnum.next ();
                Attributes attrs = result.getAttributes();
                System.out.println(attrs.get("cn"));
            }
            namingEnum.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private SearchControls getSimpleSearchControls() {
        SearchControls searchControls = new SearchControls();
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        searchControls.setTimeLimit(30000);
        return searchControls;
    }
}