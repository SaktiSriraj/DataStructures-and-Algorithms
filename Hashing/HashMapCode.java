import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {
    static class HashMaps<K, V> { //generics
        private class Node{
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; //n - nodes
        private int N; //N - buckets

        private LinkedList<Node> buckets[]; //N = buckets.length

        @SuppressWarnings("unchecked")
        public HashMaps(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4l;i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        //hashFunction to find the bucket index
        public int hashFunction(K key){
            int bi = key.hashCode(); //hashCode - returns any number in the range of dataType
            return Math.abs(bi) % N;

        }

        //Search in LL
        private int searchInLL(K key, int bi){
            LinkedList<Node> l = buckets[bi];
            
            for(int i = 0; i < l.size(); i++){
                if (l.get(i).key == key)
                    return i; //di
            }

            return -1;
        }

        //Re-hash method
        @SuppressWarnings("unchecked") //To supress the warnings
        private void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N+2];

            for(int i=0; i<N+2; i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i = 0; i < oldBucket.length; i++){
                LinkedList<Node> ll = oldBucket[i];

                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key,node.value);
                }
            }

        }

        //PUT function
        public void put(K key, V value){
            int bi = hashFunction(key); //bucket index - index of array
            int di = searchInLL(key, bi); //data index - index of data in LinkedList [valid (0+), invalid(-1)]
        
            if(di == -1) { //key does not exist
                buckets[bi].add(new Node(key, value));
                n++;
            }else{ //key exists
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            double lamda = (double)n/N;
            if(lamda > 2.0){ //2.0 is a key
                //rehashing
                rehash();
            }
        }
        

        public V get(K key){
            int bi = hashFunction(key); //bucket index - index of array
            int di = searchInLL(key, bi); //data index - index of data in LinkedList [valid (0+), invalid(-1)]
        
            if(di == -1) { //key does not exist
                return null;
            }else{ //key exists
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key); //bucket index - index of array
            int di = searchInLL(key, bi); //data index - index of data in LinkedList [valid (0+), invalid(-1)]
        
            if(di == -1) { //key does not exist
                return false;
            }else{ //key exists
                return true;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key); //bucket index - index of array
            int di = searchInLL(key, bi); //data index - index of data in LinkedList [valid (0+), invalid(-1)]
        
            if(di == -1) { //key does not exist
                return null;
            }else{ //key exists
                Node node = buckets[bi].remove(di);
                return node.value;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<K>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll = buckets[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }
    }

    public static void main(String[] args) {
        HashMaps<String, Integer> map = new HashMaps<String, Integer>();
        map.put("India", 140);
        map.put("USA", 50);
        map.put("China", 120);

        System.out.println("China.value: " + map.get("China"));
        System.out.println("India present? : " + map.containsKey("India"));

        System.out.println("Keys: " + map.keySet());
        System.out.println("Empty? : " + map.isEmpty());

        System.out.println("\nComplete Map:- ");
        ArrayList<String> keys = map.keySet();
        for(int i = 0; i < keys.size(); i++)
            System.out.println(keys.get(i) + " - " + map.get(keys.get(i)));

    }
}