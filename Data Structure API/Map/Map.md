# Map

Map의 가장 큰 특징은 순서에 의존하지 않고 key로 value를 가져오는데 있다. 하지만 가끔은 Map에 입력된 순서대로 데이터를 가져오고 싶은 경우도 있고 때로는 입력된 key에 의해 소트된 데이터를 가져오고 싶을 수도 있을 것이다. 이런경우에는 LinkedHashMap과 TreeMap을 사용하는 것이 유리하다.

- LinkedHashMap은 입력된 순서대로 데이터를 저장하는 특징을 가지고 있다.
- TreeMap은 입력된 key의 오름차순 순서로 데이터를 저장하는 특징을 가지고 있다.

# 선언

- HashMap<String, String> map = new HashMap<>();

# 추가

- put(K key, V value)
- putAll(Map<? extends K, ? extends V> m)

# 조회

- containsKey(Object key)
- containsValue(Object Value)
- entrySet()
- keySet()
- get(Object key)
- values()
- size()
- isEmpty()

# 삭제

- clear()
- remove(Object key)

# 수정

- put(K key, V value)
- putAll(Map<? extends K, ? extends V> m)
