����   2 g kotlin/time/MeasureTimeKt  java/lang/Object  measureTime #(Lkotlin/jvm/functions/Function0;)D 2(Lkotlin/jvm/functions/Function0<Lkotlin/Unit;>;)D Lkotlin/SinceKotlin; version 1.3 Lkotlin/time/ExperimentalTime; #Lorg/jetbrains/annotations/NotNull;     block  kotlin/jvm/internal/Intrinsics  checkParameterIsNotNull '(Ljava/lang/Object;Ljava/lang/String;)V  
    kotlin/time/TimeSource$Monotonic  INSTANCE "Lkotlin/time/TimeSource$Monotonic;  	   kotlin/time/TimeSource  markNow ()Lkotlin/time/TimeMark;      kotlin/jvm/functions/Function0 " invoke ()Ljava/lang/Object; $ % # & kotlin/time/TimeMark ( 
elapsedNow ()D * +
 ) , mark$iv Lkotlin/time/TimeMark; $this$measureTime$iv Lkotlin/time/TimeSource; $i$f$measureTime I  Lkotlin/jvm/functions/Function0; ;(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)D J(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0<Lkotlin/Unit;>;)D $this$measureTime 7 mark measureTimedValue :(Lkotlin/jvm/functions/Function0;)Lkotlin/time/TimedValue; [<T:Ljava/lang/Object;>(Lkotlin/jvm/functions/Function0<+TT;>;)Lkotlin/time/TimedValue<TT;>; kotlin/time/TimedValue = <init> D(Ljava/lang/Object;DLkotlin/jvm/internal/DefaultConstructorMarker;)V ? @
 > A 	result$iv Ljava/lang/Object; $this$measureTimedValue$iv $i$f$measureTimedValue R(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)Lkotlin/time/TimedValue; s<T:Ljava/lang/Object;>(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0<+TT;>;)Lkotlin/time/TimedValue<TT;>; $this$measureTimedValue I result Lkotlin/Metadata; mv       bv    k    d1��"
��

��




��

,��0200Hø��

 ¢0H0"��2H0H

 0��0*0	200Hø��

 ¢
4H0"��*0	2H0H

 
¨ d2 Lkotlin/time/Duration; Lkotlin/Function0;   Lkotlin/time/TimedValue; T kotlin-stdlib measureTime.kt Code LineNumberTable LocalVariableTable 	Signature RuntimeInvisibleAnnotations $RuntimeInvisibleParameterAnnotations 
SourceFile SourceDebugExtension RuntimeVisibleAnnotations 1            ^   �     ,<*� =� � M>6,� ! :*� ' W� -�    _     	     W  [  \ & ] `   4    . /    0 1    2 3    ,  4    ) 2 3  a     b       	s 
    c          5  ^   x     $=*8� +� >*� ! N+� ' W-� -�    _      !  %  &  ' `   *    9 /    $ 7 1     $  4   ! 2 3  a    6 b       	s 
    c             : ;  ^   �     7<*� =� � M>6,� ! :*� ' :� >Y� -� B�    _     	 >  B  ^  b  c ' d `   >  '  C D    . /   $ E 1   " F 3    7  4    4 F 3  a    < b       	s 
       c         : G  ^   �     /=*J� +� >*� ! N+� ' :� >Y-� -� B�    _      N  R  S   T `   4     K D    9 /    / I 1     /  4   , F 3  a    H b       	s 
       c             d    ] e   �SMAP
measureTime.kt
Kotlin
*S Kotlin
*F
+ 1 measureTime.kt
kotlin/time/MeasureTimeKt
*L
1#1,86:1
33#1,7:87
78#1,7:94
*E
*S KotlinDebug
*F
+ 1 measureTime.kt
kotlin/time/MeasureTimeKt
*L
21#1,7:87
66#1,7:94
*E
 f   X  L  M[ I NI NI O P[ I NI I Q RI S T[ s U V[ s s Ws s Xs Ys s :s Zs [s 1s 5s \                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     