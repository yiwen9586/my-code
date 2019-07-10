import java.util.*;

public class Block {
	static String sha1(String text) {
		String sha1 = "";
		try {
			java.security.MessageDigest crypt = java.security.MessageDigest.getInstance("SHA-1");
			crypt.update(text.getBytes("UTF-8"));
			Formatter formatter = new Formatter();
			for(byte b : crypt.digest()) {
				formatter.format("%02x", b);
			}
			sha1 = formatter.toString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return sha1;
	}
	
	static String[] getNonceAndBlockHash(String prevBlockHash, String transactions) {
		int nonce = 0;
		String[] res = new String[2];
		while(true) {
			String blockHash = sha1(prevBlockHash +", "+ nonce+", " + transactions);
			if(blockHash.substring(0, 4).equals("0000")) {
				res[0] = String.valueOf(nonce);
				res[1] = blockHash;
				break;
			}
			nonce++;
		}	
		return res;
	}
	
	static String transactionsToString(int[][] transactionsInBlock) {
		String transactions = "[";
		for(int[] trans : transactionsInBlock) {
			transactions += "[" + trans[0] + ", ";
			transactions += trans[1] + ", ";
			transactions += trans[2] + "], ";
		}
		transactions = transactions.substring(0,transactions.length()-2) + "]";
		return transactions;
	}
	
	static String getLatestBlock(int[] startBalances, int[][] pendingTransactions, int blocksize) {
		String prevBlockHash = "0000000000000000000000000000000000000000";
		String prevBlock = "";
		List<int[]> validtrans = new ArrayList<int[]>();
		for(int[] pending : pendingTransactions) {
			if(startBalances[pending[0]] < pending[2]) continue;
			validtrans.add(pending);
			startBalances[pending[0]] -= pending[2];
			startBalances[pending[1]] += pending[2];
			if(validtrans.size() == blocksize) {// one block. calculate prevBlockHash and prevBlock
				int[][] valids = validtrans.toArray(new int[1][3]);
				String transactions = transactionsToString(valids);
				String[] curNonceAndHash = getNonceAndBlockHash(prevBlockHash, transactions);
				prevBlock = curNonceAndHash[1] + ", " + prevBlockHash + ", " + curNonceAndHash[0] + ", " + transactions;
				prevBlockHash = curNonceAndHash[1];
				validtrans.clear();
			} 
		}
		// if has remain transactions, calculate again
		if(validtrans.size() > 0) {
			int[][] valids = validtrans.toArray(new int[1][3]);
			String transactions = transactionsToString(valids);
			String[] curNonceAndHash = getNonceAndBlockHash(prevBlockHash, transactions);
			prevBlock = curNonceAndHash[1] + ", " + prevBlockHash + ", " + curNonceAndHash[0] + ", " + transactions;		
		}
		
		return prevBlock;
	}
	
	 public static void main(String[] args) {
		 int[] startBalances = new int[] {1,7};
		 int[][] pendingTransactions = new int[][] {{1,0,4},{1,0,3},{1,0,2}};
		 int blocksize = 2;
		    System.out.println(getLatestBlock(startBalances, pendingTransactions, blocksize));
	 }
}
