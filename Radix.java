public class Radix{
  public static int nth(int n, int col){
    int last = (Math.abs(n) % (int) Math.pow(10, (col+1)));
    return last/((int) Math.pow(10, col));
  }
  public static int length(int n){
    if(n == 0){
      return 1;
    }
    return (int)Math.log10(Math.abs(n)) + 1;
  }
  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets){
    for(int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }
  // private static int largest(SortableLinkedList data){
  //   int result = 0;
  //   for(int i = 0; i < data.size(); i++){
  //     if(length(data.get(i)) > result){
  //       result = length(data.get(i));
  //     }
  //   }
  //   return result;
  // }
  public static void radixSortSimple(SortableLinkedList data){
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    buckets[0] = new SortableLinkedList();
    buckets[1] = new SortableLinkedList();
    buckets[2] = new SortableLinkedList();
    buckets[3] = new SortableLinkedList();
    buckets[4] = new SortableLinkedList();
    buckets[5] = new SortableLinkedList();
    buckets[6] = new SortableLinkedList();
    buckets[7] = new SortableLinkedList();
    buckets[8] = new SortableLinkedList();
    buckets[9] = new SortableLinkedList();
    int largest = 0;
    while(data.size() > 0){
      if(length(data.get(0)) > largest){
        largest = length(data.get(0));
      }
      buckets[nth(data.get(0), 0)].add(data.get(0));
      data.remove(0);
    }
    merge(data, buckets);
    for(int i = 1; i < largest; i++){
      while (data.size() > 0){
        buckets[nth(data.get(0), i)].add(data.get(0));
        data.remove(0);
      }
      merge(data, buckets);
    }
  }
  public static void radixSortSimpleRev(SortableLinkedList data){
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    buckets[0] = new SortableLinkedList();
    buckets[1] = new SortableLinkedList();
    buckets[2] = new SortableLinkedList();
    buckets[3] = new SortableLinkedList();
    buckets[4] = new SortableLinkedList();
    buckets[5] = new SortableLinkedList();
    buckets[6] = new SortableLinkedList();
    buckets[7] = new SortableLinkedList();
    buckets[8] = new SortableLinkedList();
    buckets[9] = new SortableLinkedList();
    int largest = 0;
    while(data.size() > 0){
      if(length(data.get(0)) > largest){
        largest = length(data.get(0));
      }
      buckets[Math.abs(nth(data.get(0), 0)-9)].add(data.get(0));
      data.remove(0);
    }
    merge(data, buckets);
    for(int i = 1; i < largest; i++){
      while (data.size() > 0){
        buckets[Math.abs(nth(data.get(0), i)-9)].add(data.get(0));
        data.remove(0);
      }
      merge(data, buckets);
    }
  }
  public static void radixSort(SortableLinkedList data){
    //probably not most efficient, but scales linearly and works.
    SortableLinkedList positive = new SortableLinkedList();
    SortableLinkedList negative = new SortableLinkedList();
    // for(int i = 0; i < data.size(); i++){
    //   if(data.get(i) < 0){
    //     negative.add(data.get(i));
    //   }else{
    //     positive.add(data.get(i));
    //   }
    // }
    while(data.size() > 0){
      if(data.get(0) < 0){
        negative.add(data.remove(0));
      }else{
        positive.add(data.remove(0));
      }
    }
    radixSortSimple(positive);
    radixSortSimpleRev(negative);
    // int neg = negative.size();
    // int pos = positive.size();
    // for(int i = 0; i < neg; i++){
    //   data.set(i, negative.get(i));
    // }
    // for(int i = neg; i < neg + pos; i++){
    //   data.set(i, positive.get(i-neg));
    // }
    // while(negative.size() > 0){
    //   data.add(negative.remove(0));
    // }
    // while(positive.size() > 0){
    //   data.add(positive.remove(0));
    // }
    data.extend(negative);
    data.extend(positive);
  }
}
