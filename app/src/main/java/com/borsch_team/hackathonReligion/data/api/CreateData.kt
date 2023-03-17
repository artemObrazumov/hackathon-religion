package com.borsch_team.hackathonReligion.data.api

import com.borsch_team.hackathonReligion.data.models.Church
import com.borsch_team.hackathonReligion.data.models.Parishes
import com.google.firebase.firestore.FirebaseFirestore
import java.util.UUID

class CreateData {
    companion object {
        /*fun createData(){
//            var id = UUID.randomUUID().toString()
//            FirebaseFirestore.getInstance().collection("Churches").document(id).set(
//                Church(id, 55.385326, 43.817554, false, "Name1", "desc", arrayListOf("url1", "url2"))
//            )
//            id = UUID.randomUUID().toString()
//            FirebaseFirestore.getInstance().collection("Churches").document(id).set(
//                Church(id, 0.00, 0.00, true, "Name1", "desc", arrayListOf("url1", "url2"))
//            )
//            id = UUID.randomUUID().toString()
//            FirebaseFirestore.getInstance().collection("Churches").document(id).set(
//                Church(id, 0.00, 0.00, true, "Name1", "desc", arrayListOf("url1", "url2"))
//            )
            /*val id = UUID.randomUUID().toString()
            FirebaseFirestore.getInstance().collection("Parishes").document(id).set(
                Parishes(id, "title1", "url", "description", "zacritie", "vosstanovlenie", "")
            )*/*/

            fun createData(){
                var id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.387118, 43.813476, false, "Кафедральный собор во славу Воскресения Христова", "Построенный целиком на народные деньги, Воскресенский собор воздвигнут в благодарение Господу Богу за победу в Отечественной войне 1812 года как памятник героизму русских воинов. Воскресенский собор был заложен в 1814 году. Его проект в стиле русского классицизма выполнил талантливый арзамасец Михаил Петрович Коринфский (1788—1851), ученик художника А. В. Ступина, а затем — архитектора А.Н.Воронихина. Перед началом строительства был разобран прежний обветшавший собор Воскресения Христова, который стоял в другом месте города. На месте же нового собора находились деревянные домики обывателей. Их скупали на слом и употребляли на обжиг кирпичей. Для строительства храма специально открыли кирпичные заводы, которые назывались «соборными», где произвели 5, 5 млн. штук кирпича. Кладка стен продолжалась с 1814 по 1821 год. Кроме кирпичей потребовалось 1000 кубических сажен (9718 кубометров) бутового камня для фундамента и 10000 пудов (163,8 т) железа. Строительство продолжалось 28 лет. Отделочные работы и роспись длились 21 год.  Все своды и стены храма расписали художники-ступинцы — Осип Семенович Серебряков с сыном Александром и помощниками. Впоследствии Осип Серебряков вступил в число братии Саровского Свято-Успенского монастыря. А принадлежащий его кисти портрет преподобного Серафима Саровского стал самым известным иконописным изводом образа этого святого. Иконостасы резной работы выполнены братьями Василием и Климом Ломакиными. Все пять иконостасов обрамлены огромными деревянными колоннами с капителями, украшенными пилястрами с резьбой. Царские врата главного престола украшены иконами Спасителя и Богоматери, которые изображены восседающими на царских тронах, в белых одеждах, с коронами на главах, — работы профессора живописи Николая Алексеева (зятя Ступина), расписывавшего впоследствии Исаакиевский собор Санкт-Петербурга. Здание имеет форму греческого креста, положенного на квадрат. Вся постройка поднята на ступенчатое основание ─ так называемый стилобит. Длина и ширина храма равны и имеют по 30 сажен (63 м 90 см), а высота до среднего креста — 22 сажени (46 м 86 см). Собор имеет пять куполов сферической формы, высокие фронтоны, украшенные живописью, четыре портика, опирающиеся в совокупности на 48 колонн. На фронтонах собора расположены большие фрески на библейские сюжеты: «Воскресение Христа» (восточный фронтон), «Явление Святой Троицы Аврааму» (южный), «Собор всех святых» (западный), «Покров Пресвятой Богородицы» (северный). В честь освящения храма 15 сентября 1840 года стеклось необычайное количество народа — так много было желающих стать свидетелями исторического момента в их городе. После освящения подсчитали количество свечных огарков, оно должно было совпадать с количеством богомольцев, присутствовавших на площади. Их насчитали целых 12 тысяч. С 1887 года главный престольный праздник в Воскресенском соборе совершается 13 сентября(26 сентября по н. стилю) в память обновления (или освящения) царицей Еленой храма воскресения Христова в Иерусалиме в 335году. Этот день называется «Воскресение словущее». «По общему облику и прекрасным пропорциям Арзамасский Воскресенский собор не имеет себе равного среди классических церквей Москвы и может идти в сравнение лишь с петербургскими соборами Стасова», — писал в 1926 году архитектор-реставратор Николай Померанцев.В Арзамасе было принято в каждом приходе иметь по два храма: зимний теплый, с печами, и летний или холодный. Воскресенский собор – холодный. В нем богослужения совершаются в период от Пасхи до Покрова. А в холодное время года работает второе здание — отапливаемый храм во имя Пресвятой Богородицы, Ея Живоносного источника, построенный еще раньше, в 1794 году.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.387644, 43.813391, false, "Церковь в честь иконы Божией Матери «Живоносный Источник»", "Был возведен в 1794 году как теплый, зимний, храм кафедрального собора во славу Воскресения Христова. Вместе с колокольней его заложили на месте старой каменной церкви, дата построения которой неизвестна. В 1795 году был освящен главный придел. Архитектура церкви носит переходный характер от барокко к классицизму.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.387631, 43.813519, false, "Крестильная церковь", "Крестильная церковь в Честь Казанской иконы Божией Матери была возведена в 2002 году. В храме установлена большая крестильная купель, для принятия таинства крещения взрослыми. Богослужения совершаются несколько раз в год только по особым дням.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.385565, 43.817464, false, "Церковь в честь Благовещения Пресвятой Богородицы", "На месте, где сейчас стоит Благовещенский храм, до 1775 года находились две церкви, составлявшие единый приход: деревянная, холодная, в честь Благовещения Пресвятой Богородицы, имевшая два придела: правый – во имя св. Иоанна Предтечи и левый – во имя Архистратига Михаила и прочих Небесных Сил; другая церковь, каменная, теплая, во имя трех вселенских святителей: Василия Великого, Григория Богослова и Иоанна Златоустого, также с двумя приделами: правым – во имя святого Николая Чудотворца и левым – во имя св. мученицы Параскевы Пятницы. Возле этих храмов было приходское кладбище.Издавна прихожанами этого прихода, как будто на подбор, были преимущественно богатые люди. Когда дела их особенно стали процветать, они решили создать Господу от своих праведных трудов благолепный храм. Инициатором был дворянин Иван Михайлович Булгаков (пожертвовавший ранее на этот храм драгоценное евангелие), потомок арзамасского воеводы Тимофея Булгакова. Много старался и протоиерей этого храма Иоанн Андреев, изготовивший серебряный напрестольный крест, в который были вложены частицы св. мощей и часть Животворящего Древа Креста Господня. Новую Благовещенскую церковь начали возводить в 1775 г. и завершили в 1788 г. Постройка производилась на средства прихожан, которые не скупились, старались сделать все качественно и прочно. Церковь была воздвигнута двухрамовая: на первом этаже теплая, а на втором – холодная. Всего было сделано 6 престолов, которые были посвящены тем же святым, что и в старых церквях. Облик храма и архитектура избраны были весьма удачно и частично заимствованы с Успенского собора Саровской пустыни, построенного незадолго до этого. Храм восхищал сердца прихожан и жителей города своим величественным наружным видом, великолепием своего позолоченного иконостаса и прекрасными иконами. Колокольня церкви была самой высокой в городе (12 сажен). Церковь считалась самой богатой в городе. Её прихожанами были купцы, зажиточные горожане, и потому в народе её называли «купеческой». Строительство этой новой каменной двухэтажной Благовещенской церкви положило начало строительству двадцати пяти церквей города в его «золотой век».",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.383998, 43.816065, false, "Церковь в честь Владимирской иконы Божией Матери", "23 марта 1802 года Иоанном, бывшим игуменом спасским, а тогда уже архимандритом Макарьевскаго Желтоводскаго монастыря освящена новопостроенная каменная холодная церковь во имя Владимирской иконы Божией Матери, в трапезе которой, впоследствии, устроено два придела: правый - Зосимы и Савватия соловецких чудотворцев и левый - св. Димитрия Ростовскаго. Церковь эта построена в замен старой каменной, существовавшей с 1681 года и построенной вместо деревянной, сгоревшей, время основания которой неизвестно. Место для строительства храма было выбрано очень удачно. Совсем рядом проходил знаменитый и многолюдный московский тракт, по которому в любое время проезжало много купцов, торговцев и простого люда. Усталые путники прежде всех дел посещали церкви, а ближайшей оказывалась Владимирская церковь. Посещали церковь и местные жители. Это приносило церкви большой доход. По красоте и убранству храм не уступал другим. Здесь был богатейший иконостас, крашенный по золоту драгоценными камнями. В 1866 году при Владимирской церкви было открыто третье по счету в Арзамасе мужское приходское училище.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.384111, 43.820277, false, "Церковь в честь Входа Господня в Иерусалим", "Церковь в честь Входа Господня в Иерусалим в Арзамасе была построена в 1777 году. В 1883 обгорела, после чего перестроена. Прямоугольная в плане односветная постройка с небольшим декоративным куполм. Приделы Стефана Архидиакона и мучеников Евстратия, Авксентия, Евгения, Мардария и Ореста. Именно здесь по благословению Серафима Саровского начинал нести свои молитвенные труды и подвиг юродства Христа ради Блаженная Пелагея – Пелагея Ивановна Серебрянникова (Сурина).",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.382985, 43.824102, false, "Церковь в честь Рождества Христова", "Своим появлением храм обязан арзамасскому купцу Александру Михайловичу Заяшникову. Младшая дочь купца, Евдокия, получила от отца приданное в 50 тысяч рублей. Дело оставалось за малым – найти жениха. Однако 25 августа 1845 года она внезапно умерла, и скорбящий отец по совету своего духовного наставника – настоятеля Рождественской церкви отца Дмитрия Раевского, решил всю сумму приданного истратить на постройку храма. Обет был дан, заказан план церкви у архитектора К.А. Тона, автора Храма Христа Спасителя в Москве, но видеть его исполнение Александру Михайловичу не пришлось. 4 ноября 1846 года он умер и строительство перешло под ведение его жены и зятя, дворянина Николая Яковлевича Стобеуса. Были расписаны фасады, местными мастерами братьями Лысковцевыми были вызолочены главы храма; установлен «величественный», один из лучших в Арзамасе, иконостас, выполненный в мастерской архитектора М.П. Коринфского (Веренцова). Кроме главного, храм получил еще два престола: правый в честь Благовещения Прествятой Богородицы и левый в честь святителя Николая Чудотворца. Освящение храма состоялось 1 октября 1850 года. Церковь в честь Рождества Христова считалась венцом храмостроительства «золотого века» Арзамаса.Здание Рождественской церкви с двумя пределами было выстроено и полностью готово к освещению в сентябре 1850 г. Освещен храм был 1 октября 1850 г. в честь Рождества Христова.", arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.383467, 43.823786, false, "Церковь в честь Смоленской иконы Божией Матери", "Церковь была построена в 1703 году на деньги арзамасского купца Ивана Васильевича Маслёнкова. Это был человек весьма почитаемый в Арзамасе, духовный друг иеромонаха Иоанна, основателя Саровской пустыни. В 1797 году на месте прежнего Смоленского храма построена и освящена просторная каменная церковь с тем же именем с двумя приделами: первый в честь апостола и евангелиста Иоанна Богослова; второй – во имя благоверного князя Александра Невского и преподобного Александра Свирского. Храм строился на средства «благочестивых богачей» Маслёнковых, Корниловых, Быстровых и многих других.", arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.386998, 43.823246, false, "Церковь во имя святого апостола Андрея Первозванного", "Холодная Ильинская церковь построена в 1746 году и являет собой образец каменной архитектуры раннего барокко. Основным элементом украшения апсиды, стен четверика и трапезной являются богато орнаментированные наличники окон и карнизы, узорчатым поясом охватывающие верхние части объемов. Ребра объемов храма и трапезной отделаны в виде тройчатых полуколонн, как бы завершающих орнаментальную рамку. Ильинская церковь свидетельствует о большом искусстве арзамасских мастеров. Узоры, образующие на гладкой поверхности стен ажурное плетение, придают зданию храма пластичность и легкость.По свидетельству Н.М.Щеголькова, церковь была построена «чрезвычайно фундаментально и прочно: стены двухаршинной толщины, окна даже в куполе с решетками, что указывает на то, как тогда боялись разбойников, а может быть, даже и неприятельского нашествия. Пол в этой церкви был чугунный, пожертвованный прихожанами, именитыми купцами Цыбышевыми, которые имели тогда свои собственные чугунные заводы».",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.386305, 43.823174, false, "Церковь во имя святого пророка Божия Илии", "«В 1793 году в Ильинском приходе построена небольшая теплая церковь, двухпрестольная. Правый придел посвящен св. Апостолу Андрею Первозванному, святому покровителю одного из жертвователей, именитого купца Андрея Цыбышева, а левый св. Симеону Богоприимцу и Анне Пророчицы. Церковь эта довольно долго была неблагоустроенной, но со временем она перекрыта железом, устроен новый, позлащенный иконостас, а в 1870-х годах купец Петр Рукавишников на собственный счет сделал к ней каменную пристройку» - так пишет о строительстве этой церкви Н.М.Щегольков. Андреевская церковь - один из интереснейших храмов рационального барокко середины-конца XVIII века, господствовавшего в Арзамасе и приобретшего ярко выраженные местные архитектурные черты.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.389539, 43.813117, false, "Церковь в честь Казанской иконы Божией Матери", "В 1792 году в Крестовоздвиженском приходе Арзамаса была выстроена теплая церковь в честь Казанской иконы Божией Матери, поскольку здесь находился чудотворный образ, обретенный горожанами в 1643 году. По свидетельству историка-краеведа Н. М. Щеголькова, 1643 год ознаменовался перенесением в Арзамас и прославлением чудотворной иконы — Казанского образа Божией Матери, который находится в Крестовоздвиженской церкви.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.392486, 43.809896, false, "Церковь в честь Сошествия Святаго Духа на апостолов", "Первоначально на месте нынешней постройки располагалась деревянная Троицкая церковь — главный храм Троицкого мужского монастыря. В 1764 году монастырь был расформирован, и церковь стала приходской. По ходатайству священника этого храма Пантелеимона Иванова и прихожан в 1777 году была перестроена в камне. В 1833 году церковь снова перестроили и освятили в честь Сошествия Святого Духа (Святодуховской) для отличия от соседней Троицкой церкви («Белой Троицы») Вскоре после этого при содействии академика живописи А.В.Ступина значительно обогатилось внутреннее убранство храма, в частности был установлен новый иконостас.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.392749, 43.810885, false, "Церковь в честь иконы Божией Матери «Знамение»", "Церковь в честь иконы Божией Матери «Знамение» была построена в стиле барокко в 1801 году на месте старой церкви и являлась зимней церковью прихода церкви Троицы Живоначальной с двумя приделами: правым - во имя Гурия и Варсонофия казанских чудотворцев; левым - во имя преподобного Феодосия Тотемского.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.385602, 43.819382, false, "Собор в честь Преображения Господня", "", arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.384916, 43.818663, false, "Церковь в честь Рождества Пресвятой Богородицы", "", arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.385233, 43.819234, false, "Церковь во имя святого великомученика Георгия", "", arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.385236, 43.817557, false, "Церковь в честь Успения Пресвятой Богородицы", "", arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 0.00, 0.00, false, "Церковь в честь иконы «Всех скорбящих радость»", "", arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.387865, 43.814533, false, "Церковь во имя святого Николая Чудотворца", "", arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.386477, 43.814534, false, "Церковь в честь Богоявления Господня", "", arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.395959, 43.807427, false, "Церковь в честь Успения Пресвятой Богородицы", "", arrayListOf("url1", "url2"))
                )





                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.364757, 43.821068, false, "Церковь Иоанна Богослова", "", arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.373057, 43.826708, false, "Церковь Тихвинской иконы Божией Матери", "", arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.409427, 43.818003, false, "Церковь апостолов Петра и Павла", "", arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.417678, 43.766884, false, "Высокогорский Вознесенский мужской монастырь", "", arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.384548, 43.817379, false, "Часовня Спаса Нерукотворного Образа в Спасском Арзамасском монастыре", "", arrayListOf("url1", "url2"))
                )



                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.386282, 43.815391, true, "Церковь в честь Введения во храм Пресвятой Богородицы", "Деревянная церковь была построена в 1651 году и имела два придела: во имя архидиакона Стефана и во имя преподобномученицы Евдокии. Строилась она при скудных средствах и быстро пришла в ветхость. С 1652 года вокруг нее расположился Введенский мужской монастырь. Через сорок лет по челобитью Введенского старца Авраамия с братией Патриарх Адриан дал разрешение на постройку вместо ветхой деревянной двух каменных церквей: летней Введенской и зимней во имя преподобномученицы Евдокии. Первый храм был построен в 1692 году, а второму не суждено было появиться вследствие указа Петра I 1714 года о приостановлении каменных построек в провинциальных городах. С 1689 по 1691 годы в монастыре подвизался великий подвижник XVII столетия схимонах Иоанн, основатель Саровской пустыни. В 1764 году Введенский монастырь был упразднен, а его храм приписан к Воскресенскому собору. В 1810-1812 годах церковь снова перестроили – к ней добавили двухэтажную трапезу и колокольню. В верхнем этаже пристройки устроили приделы: правый в честь иконы Божией Матери «Всех скорбящих Радость», левый — во имя Иоанна Предтечи и Святителя Николая Чудотворца. В нижнем этаже правый придел освятили в честь преподобномученицы Евдокии, а левый в честь мучениц Веры, Надежды, Любови и матери их Софии. Этот последний придел был устроен значительно позже усердием купцов Подсосовых. После перестройки храм потерял свою прежнюю красоту и являл собой смешение архитектурных стилей. Введенская церковь дважды объявлялась самостоятельной и дважды опять приписывалась к собору. Причина заключалась в бедности прихожан. Лишь после того, как почетные граждане Арзамаса и купцы Подсосовы добровольно перешли из Благовещенского прихода во Введенский, тот зажил относительно хорошо. На средства богатых прихожан соорудили новые позолоченные иконостасы, украсили иконы серебряными ризами и пополнили ризницу ценными облачениями.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.383596, 43.815432, true, "Церковь в честь Богоявления Господня", "В 1818 году во Владимирском приходе освящен новый большой теплый храм в честь Богоявления Господня с приделами: правым - св. великомученика Димитрия Солунского и левым - св. великомученицы Варвары. Храм этот построен вместо прежнего каменного, того же времени, существовавшего с 1764 года, на новом месте, которое было пожертвовано прихожанами: купцом Иваном Васильевичем Свешниковым и мещанином Иваном Ивановичем Цыбышевым-Белугою, имевшими на этом месте свои дома. Последний, т.е. И.И.Белуга был и строителем храма и, как человек бездетный, провел остаток дней своих при храме, где у него была устроена в колокольне келия. Строителям этого храма пришла блестящая мысль устроить под ним палатки для склада товаров. Помещения оказались удобными, сухими и приносящими церкви и причту постоянный значительный доход. Палатки эти служили главным образом для склада мехов, выделываемых арзамасскими купцами.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.389051, 43.812931, true, "Церковь в честь Воздвижения Животворящего Креста Господня", "Кирпичная церковь в честь Воздвижения Животворящего Креста Господня была построена в 1682. Это была высокая летняя церковь в стиле классицизма. В трапезной имелись приделы двенадцати Апостолов и преподобного Макария Желтоводского. Поэтому церковь имела и второе название - Макарьевская. К 1860 году при церкви существовало приходское училище, в 1862 году открыта духовная публичная библиотека, а в 1889 году — первая в Арзамасе церковно-приходская школа.", arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.391917, 43.811393, true, "Церковь в честь Святой Живоначальной Троицы", "Большой, холодный, кирпичный, однокупольный храм св. Живоначальной Троицы был построен в 1824 году. Храм имел два придела: в честь Казанской иконы Божией Матери и святого Иоанна Предтечи. Основными жертвователями средств на обновление храма являлись двое арзамасцев: церковный староста купец И.Ф. Перетогин, и мещанин С.И. Казанин. В народе она стала именоваться «Белой Троицей», в отличие от «Чёрной Троицы» - одноимённого главного храма мужского Троицкого монастыря, расположенного неподалёку.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.399345, 43.828297, true, "Церковь в честь Всех святых", "Со дня основания Арзамаса, умерших хоронили на погостах городских церквей. Причем такая ситуация была характерна для всей России того времени. Расположение кладбищ в городской черте нередко способствовало возникновению и распространению различных эпидемий. В 1771 году последовал указ, запрещавший погребать покойных при церквях и устроении кладбищ вне городов. Согласно этому в Арзамасе было основано два кладбища: в нижней и верхней частях города. В 1796-1797 годах усердием купца Сергея Ивановича Куракина на кладбище в верхней части города была воздвигнута трехпрестольная церковь во имя Всех Святых, с алтарями во имя преподобного Сергия Радонежского и великомученицы Варвары. По названию храма и само кладбище стало именоваться Всехсвятским. До революции существовала традиция в день Всех Святых – в первое воскресенье после Троицы — к этой церкви совершать крестный ход, который был одним из самых многолюдных в Арзамасе. На Всехсвятском кладбище были погребены многие известные горожане: почетный гражданин Арзамаса протоиерей Федор Владимирский – строитель городского водопровода, академик Александр Васильевич Ступин – основатель первой провинциальной школы живописи, отец Аркадия Гайдара - П.И. Голиков, родители патриарха Московского и всея Руси Сергия (Страгородского), а также в братской могиле - герои войны 1812 года, умершие в Арзамасе от ран, над братской могилой которых был насыпан курган и водружен крест.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.396572, 43.808506, true, "Церковь в честь Успения Пресвятой Богородицы", "Храмы Софийского прихода более трех веков украшали и одухотворяли северно-западные окраины города. Первая церковь, построенная на этом месте, была освящена в честь Софии, премудрости Божией. Церковь во имя св. Софии в Арзамасе была одной из древнейших. Вероятно, возводили храм благочестивые и мастеровитые новгородцы, переселенные в Арзамас после усмирения и опустошения Великого Новгорода Иоанном Грозным в 1580 году, в память о своем городе и его святыне - Софийском соборе.  Церковь эта много раз перестраивалась. Как отмечает Н. Щегольков, на этом месте в свое время сменились, вероятно, две деревянные постройки. В 1713 году по челобитью г. Арзамаса софийского попа Василия здесь было выстроено первое каменное здание. Но в те годы по указу Петра Великого было запрещено посвящать церкви чудотворным иконам, и церковь тогда посвятили Честному Успению. К сожалению, в храме не осталось никаких следов древности, кроме нескольких старинных икон, среди которых есть и икона св. Софии, Премудрости Божией «новгородскаго, а не киевскаго начертания» В 1791 году освящена церковь во имя Успения Пресвятой Богородицы, именуемая Софийская. Церковь эта имела форму креста, в ней два придела: — правый во имя св. Петра, Митрополита Московскаго, и левый - преп. Сергия Радонежскаго. Воздвигнут был этот храм усердием купца Петра Чулошникова, поэтому правый придел и посвящен имени его ангела. Чулошников имел каменный дом близ Софийской церкви, в котором впоследствии была открыта городская общественная богадельня. При доме у него был кожевенный завод.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.396880, 43.806859, true, "Церковь в честь Сошествия Святаго Духа на апостолов", "В 1752 году в Софийском приходе с северной стороны от Успенского храма была построена небольшая каменная теплая церковь в честь Сошествия  Святого Духа на Апостолов с пределом во имя преп. Марона чудотворца.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.391815, 43.819766, true, "Церковь в честь Покрова Пресвятой Богородицы", "Строительство первого Покровского храма в нашем городе относится еще к XVII веку. В 1782 году достроен и освящен новый теплый каменный  храм в честь Покрова Пресвятой Богородицы. Храм был небольшим,  с круглой трапезой и колокольней. В трапезной части было два придела: в честь трех святителей (Василия Великого, Григория Богослова, Иоанна Златоуста) и великомученицы Екатерины. При постройке храма особо потрудился церковный староста Мартьянов.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.391963, 43.818948, true, "Церковь в честь Нерукотворного Образа Спасителя", "Спасская церковь находилась вне Арзамасской крепости, но у самой городской стены, и в старину называлась в отличие от Спасского монастыря, «Спас на проломе».  В 1683 году посадский человек Иван Сальников получил от патриарха Иоакима грамоту на строительство двух новых деревянных церквей, холодной Спасской и теплой Покровской. Но в 1780 году, согласно устному преданию, Спасский храм сгорел дотла, а на месте пожарища нашли неповрежденную икону «Нерукотворный образ», к которой не прикоснулось пламя. В 1798 году на этом месте была построена каменная однопрестольная церковь во имя Нерукотворного Образа Господа Иисуса Христа. Весь комплекс был обнесен каменной оградой, вокруг него сформировалась Спасская площадь.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.392787, 43.821410, true, "Домовой храм во имя святого преподобного Сергия Радонежского и святого великомученика Димитрия Солунского при Арзамасском духовном училище", "7 августа 1897 года в Арзамасе на улице Сальникова было заложено новое трехэтажное здание Арзамасского духовного училища. Молебен и чин его закладки совершал настоятель Спасского монастыря архимандрит Василий, в присутствии многочисленного духовенства города. Строительство и отделочные работы здания продолжались в течение двух лет. Освящение нового корпуса состоялось 7 октября 1899 года. Автором проекта здания является епархиальный архитектор А.К. Никитин (1853-1907). Изначально в новом здание училища было предусмотрено размещение храма для воспитанников, но из-за отсутствия денег он не был выстроен сразу. Воспитанники вынуждены были ходить на богослужения в приходской Спасский храм, находившийся по соседству. 20 августа 1903 года открывается съезд депутатов Арзамасского училищного округа, на котором правление училища заявляет о пожертвовании купцом Дмитрием Андреевичем Суриным 3000 рублей на строительство домовой церкви. В благодарность за столь щедрое пожертвование, в том же году правление обращается к епископу Нижегородскому и Арзамасскому Назарию (Кириллову) с просьбой о награждении купца Д.А. Сурина «золотой медалью на Станиславской ленте». Однако пожертвованных средств на обустройство храма при училище не хватало и поэтому процесс его создания затянулся на несколько лет. Только в 1909 году начались подготовительные работы - заготовка строительных материалов, а с июля 1910 года непосредственно строительные работы. Дмовый храм при Арзамасском духовном училище был самым молодым в городе – его освящение состоялось 23 января (ст. ст.) 1910 года. Поскольку храм был построен главным образом на средства купца Дмитрия Андреевича Сурина, этим, вероятнее всего, и объясняется двойное посвящение храма: в честь преподобного Сергия как покровителя учащихся и великомученика Димитрия как небесного покровителя жертвователя. Последнее не было редкостью в Арзамасе. Сергиевский храм располагался в центральном зале, на верхнем этаже училищного корпуса. Сществовать храму пришлось совсем недолго. После революции его закрыли первым в городе.",
                        arrayListOf("url1", "url2"))
                )
                id = UUID.randomUUID().toString()
                FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                    Church(id, 55.384267, 43.820008, true, "Церковь во имя святого апостола и евангелиста Иоанна Богослова", "Есть предание, что в древности на месте Богословской церкви стоял языческий идол, которому поклонялась мордва. Вероятно, вскоре после основания города на этом месте была построена церковь, которая имела два придела: в честь святых Жен-мироносиц и Входа Господня во Иерусалим. В 1675 г. на ее месте соорудили холодный каменный храм, первоначально без приделов и трапезы. Последняя была пристроена позже. Здание поражало величественностью и строгостью. Богословская церковь, одно из самых древних и красивейших каменных зданий Арзамаса, имела купол из жёлтой черепицы, который венчался узорчатым крестом и оконные обрамления из зелёных изразцов. Внутри своим изяществом поражал резной иконостас. В 1883 г. Богословская церковь сильно пострадала от пожара и была приведена в благолепный вид старанием старосты М.В. Перетрутова и его сына.",
                        arrayListOf("url1", "url2"))
                )
            }

        }
    }
