/*
 * This class sets up the has table data structure along with
 * the utility methods to manipulate it.
 */
public class HashTable {

	private Node[] map;
	private int tableSize;
	
	// constructor
	public HashTable(int tableSize) {
		map = new Node[tableSize];
		this.tableSize = tableSize;
	}
	
	/*
	 * This is the hash function.
	 * For this hash function, return 0 if key is the empty string.
	 * Otherwise, calculate the sum of the ASCII values of the characters in key
	 * and find the remainder when divided by 8 (remember mod divisision %).
	 * Check the java API for String methods that may be helpful.
	 */
	private int hash(String key) {
		if (key == null) {
			return 0;
		} else {
			int r;
			int h = 0;
			for (int i = 0;i < key.length(); i++) {
				char k = key.charAt(i);
				r = k;
				h = h+r;
			}
			return (h%8);
		}
	}
	
	/*
	 * This method should insert a node containing the given key
	 * in the proper bucket in the hash table.  Insert new nodes
	 * at the head of each linked list for ease of implementation.
	 */
	public void insert(String key) {
		int k = hash(key);
		Node newNode = new Node(key);
		Node temp = map[k];
		map[k] = newNode;
		newNode.next = temp;
		}
	
	/*
	 * This method returs true if the search key is contained in the
	 * hash table, and false otherwise.
	 */
	public boolean search(String key) {
		int k = hash(key);
		Node pointer = map[k];
		while (pointer != null) {
			if (pointer.record == key) {
				return true;
			} else {
				pointer = pointer.next;
			}
		}
		return false;
	}
	
	/*
	 * This method should print out the hash table row by row.
	 * Each line should print out a separate row of the table.
	 * Print the index followed a colon and then the records in that
	 * bucket with spaces between them.
	 * 
	 * For example:
	 * 1: Nicholas Mary Kim Jack
	 */
	public void printTable() {
		for (int i = 0; i < tableSize; i++) {
			Node pointer = map[i];
			System.out.print("\n");
			System.out.print(i + ":");
			while (pointer != null) {
				if (pointer.record != null) {
				System.out.print(pointer.record + " ");
				pointer = pointer.next;
				} else {
					pointer = pointer.next;
				}
			}		
		}
	}
	
	/*
	 * This method should delete ALL nodes matching the search key.
	 */
	public void delete(String key) {
		int k = hash(key);
		Node pointer = map[k];
		while(pointer != null) {
			if (pointer.record == key) {
				pointer.record = null;
			} else {
				pointer = pointer.next;
			}
		}	
	}
	
}
