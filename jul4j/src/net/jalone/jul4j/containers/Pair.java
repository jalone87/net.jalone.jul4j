package net.jalone.jul4j.containers;

import java.io.Serializable;

/**
 * Unmutable multi purpose ( overall for double return type ) pair class
 * freely taken from here
 * http://www.developer.com/java/ejb/article.php/10931_3813031_2/Java-Needs-to-Get-a-Pair-and-a-Triple.htm
 * @author Lorenzo Tognalini, http://www.jalone.net
 *
 * @param <A> first element type
 * @param <B> second element type
 */
public final class Pair<A, B> implements Serializable {

	private static final long serialVersionUID = 1L; // shouldn't need to change

	public final A first;
	public final B second;

	private Pair(A first, B second) {
		this.first = first;
		this.second = second;
	}

	public static <A, B> Pair<A, B> of(A first, B second) {
		return new Pair<A, B>(first, second);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		final Pair<A, B> other = (Pair<A,B>) obj;

		if (this.first != other.first
				&& (this.first == null || !this.first.equals(other.first))) {
			return false;
		}

		if (this.second != other.second
				&& (this.second == null || !this.second.equals(other.second))) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 37 * hash + (this.first != null ? this.first.hashCode() : 0);
		hash = 37 * hash + (this.second != null ? this.second.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return String.format("Pair[%s,%s]", first, second);
	}
}