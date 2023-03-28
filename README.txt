1. Main transactions

Stream [
  MainTransaction{Id=3} ,
  MainTransaction{Id=4} ,
  MainTransaction{Id=1} ,
  MainTransaction{Id=2} ,
  MainTransaction{Id=6} ,
  MainTransaction{Id=5}
]

2. Status transactions

  Stream[
    StatusTransaction{Id=3, Status=COMPLETED} ,
    StatusTransaction{Id=1, Status=IN_PROGRESS} ,
    StatusTransaction{Id=6, Status=COMPLETED} ,
    StatusTransaction{Id=4, Status=<No Value>} ,
    StatusTransaction{Id=8, Status=COMPLETED}
    ]

/////////////////
//Implementation//
/////////////////

3. Output

Stream [
  MainTransaction{Id=3} ,
  MainTransaction{Id=6}
]

Stream<MainTransaction> s = mainStream
.filter( stream -> statusStream
.filter(status -> status.status.orElse("").equalsIgnoreCase("COMPLETED")&& status.id == steam.id ).count() ==1) ;