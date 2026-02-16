package com.example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;
public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf =
		Persistence.createEntityManagerFactory(&quot;my-persistence-unit&quot;);
		// Create EntityManager
		EntityManager em = emf.createEntityManager();
		try {
		// Create User object
		User user = new User();
		user.setUsername(&quot;John&quot;);
		// Create Set of emails
		Set&lt;String&gt; emails = new HashSet&lt;&gt;();
		emails.add(&quot;john@gmail.com&quot;);
		emails.add(&quot;john.work@gmail.com&quot;);
		emails.add(&quot;john@gmail.com&quot;); // duplicate - Set avoids it
		user.setEmails(emails);
		// Begin Transaction
		em.getTransaction().begin();
		// Persist user
		em.persist(user);
		// Commit Transaction
		em.getTransaction().commit();
		System.out.println(&quot;User saved successfully!&quot;);
		// Fetch user
		User fetchedUser = em.find(User.class, user.getUserId());
		System.out.println(&quot;User Name: &quot; + fetchedUser.getUsername());
		System.out.println(&quot;Emails: &quot; + fetchedUser.getEmails());
		} finally {
		em.close();
		emf.close();
		}
	}
}