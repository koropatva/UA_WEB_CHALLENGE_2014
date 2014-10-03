For run project you need to install
	gradle version 1.10, 
	java version 1.7

Project was written use gradle tools. So for run project just use the following command:
	gradle run
If you want to open project in the eclipse project you can run the following command:
	gradle eclipse
for idea:
	gradle idea
Default parameters you can change use the following args:
	-tl  ---> You can choose tank levels for selection(by default: 4,5,6)
	-m   ---> You can choose other name of global map(by default: globalmap)
	-tcc ---> You can choose different counts of top clans for selections(by default: 10)
Samples:
	gradle run -PappArgs="['-tl', '4, 5,6', '-m', 'globalmap', '-tcc', '10']"


The result of the program will be the similar table 

==============================================================================================================================================================
============================================================================RESULT============================================================================
==============================================================================================================================================================

FIRST CLAN NAME                                                            SECOND CLAN NAME
_X5_                                                                       eXtreme

Member name                       Country LVL Name           TankId  Power         Member name                       Country LVL Name           TankId  Power

_STrang3R_                            США   5 M4             1057      231         dieseliii                        Германия   6 Pz. V/IV       51473     399
Funny1700                          Япония   6 Chi-To         1889      377         Raptor62                             СССР   4 СУ-5           4865      135
_Peikko_                             СССР   5 КВ-220         54017     347         RybiVragov                         Япония   5 Chi-Nu         1377      224
muhac221                         Германия   5 StuG III G     1041      211         sashXP                               СССР   6 Т-150          11265     403
EKSTRIMAL                  Великобритания   6 Cromwell       1105      328         ENDEM                      Великобритания   5 Excelsior      54353     339
Bekai4eq                          Франция   5 BDR G1 B       6721      311         Rain_Man13                        Франция   6 AMX 12 t       6465      311
paarkure                              США   5 Chaffee        9761      231         C1intBeastwood                        США   5 Ram II         51745     292
GAES_kvazim                Великобритания   6 Cromwell       1105      328         batlal                            Франция   4 AMX 105 AM     14657     334
GuseinovEmil                     Германия   4 D.W. 2         13329     223         BRATishka                         Франция   4 AMX 105 AM     14657     334
Stanislav_36rus            Великобритания   5 Crusader       2129      196         Svyatik                          Германия   6 VK 36.01 H     2321      567
MASTERfoks                        Франция   6 ARL 44         2625      386         Serpov521bs                Великобритания   4 Alecto         9041      156
Agutin_                              СССР   5 КВ-220         54017     347         SLEEPERZz                        Германия   4 Luchs          6161      131
Beliy0510                             США   5 M41            4129      547         asdfcxz                              СССР   4 СУ-5           4865      135
shusanrabysondoi                  Франция   4 SAu 40         9793      183         emperer                               США   6 M6             801       407
575_V0LT                            Китай   6 59-16          4913      267         focusnik239                          СССР   5 КВ-1С          18689     319

                                                         Team balance:4513                                                                  Team balance:4486

==============================================================================================================================================================

Where are:
	Member name 	- 	Name of the selected member for game
	Country 	-	Country of the selected tank
	LVL		-	Level of the selected tank
	Name		-	Name of the selected tank
	TankId		-	Id of the selected tank
	Power		-	Power of the selected member and tank. Value that uses for balancer. The power calculated in the following way:
(Helth * 0.4 + GunDamageMax * 0.4 + GunDamageMin * 0.2) * (1 + Member mastery)
	Team balance 	-	Sum member powers of the selected team for battle


The logic of the balancer:
	1) Select 7 tanks in the random way with the selected levels
	2) Search 7 members who have this tanks and select them
	3) In the circle use balancer try to fill other members with tanks. If the difference between clans more then 200 points try to search tank with more and less power.
	4) Show results on the screen
