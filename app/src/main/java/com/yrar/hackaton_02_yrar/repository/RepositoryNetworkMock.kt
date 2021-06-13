package com.yrar.hackaton_02_yrar.repository

import com.yrar.hackaton_02_yrar.model.network.EventResponse
import com.yrar.hackaton_02_yrar.retrofit.API

class RepositoryNetworkMock(val service: API) : RepositoryNetwork {
    override fun getActualEvents(): List<EventResponse> {
        return listOf(
            EventResponse(
                "0d6b89e595e94656bca6f7909d0460ed",
                "Skolkovo Jazz Science",
                "Место, где наука и музыка соединяются, превращаясь в магию",
                "выставка",
                1630108800000,
                null,
                "Нам очень жаль прощаться с вами. " +
                    "Простите нам несколько минут ностальгии и присоединяйтесь: мы собрали фотографии за всю историю фестиваля, пересматриваем их и уже скучаем по вам. " +
                    "Когда-нибудь мы увидимся снова!",
                "г. Москва, Центральная зона, д. Центральная зона, Центральный парк",
                "admin@mail.ru",
                "https://skjazz.ru/"
            ),
            EventResponse(
                "f014b0c3cd604b5bb5c0d9611011054d",
                "10th Edition of International Conference on World Pharmaceutical Sciences & Drug Delivery",
                "Join us at World Pharma 2021 congress and gain knowledge in the areas of Pharmaceutical Science and Drug D...",
                "мероприятие",
                1629936000000,
                1630022400000,
                "Join us at World Pharma 2021 congress and gain knowledge in the areas of Pharmaceutical Science and Drug Delivery. This Conference offers a wide range of critically important scientific sessions from basic research to latest advances in the area of Pharmaceutical Science.\n" +
                    "\n" +
                    "Benefits:  1. Keynote certificate / speaker Certificate\n" +
                    "\n" +
                    "2. CPD certificate / CME certificate\n" +
                    "\n" +
                    "3. Best speaker / best young researcher award\n" +
                    "\n" +
                    "4. Journal Publication with ISSN number\n" +
                    "\n" +
                    "5. Separate Biography and research page in website.\n" +
                    "\n" +
                    "6. Conference Kit\n" +
                    "\n" +
                    "7. Lunch and breakfast.",
                "London, UK",
                "admin@mail.ru",
                "https://www.innoget.com/innovation-events/1765/10th-edition-of-international-conference-on-world-pharmaceutical-sciences-drug-delivery"
            ),
            EventResponse(
                "363c1f269843406abaedac29dfebaf82",
                "Игропрактика IP-Менеджмента «Чьи в лесу шишки?»",
                "Интеллектуальная собственность: модно, нужно, выгодно… и опасно — погоня за инвестициями, упущенной выгодой...",
                "стратегическая сессия",
                1629936000000,
                null,
                "Интеллектуальная собственность: модно, нужно, выгодно… и опасно — погоня за инвестициями, упущенной выгодой, конкурентными преимуществами и «наивное» введение в заблуждение трансформируются в репутационные потери, убытки, правонарушения… обсудим ключевые вопросы конфликтов интересов признания и закрепления интеллектуальных прав на инновации в порядке трудовых отношений:\n" +
                    "\n" +
                    "— чем подтвердить наличие и принадлежность интеллектуальных прав?\n" +
                    "— как опровергнуть наличие и принадлежность интеллектуальных прав?\n" +
                    "— чьи дивиденды, добавленная стоимость и выгоды интеллектуальных прав?\n" +
                    "— чьи проблемы имитации интеллектуальных прав и правонарушений?\n" +
                    "\n" +
                    "Целевая аудитория: предприниматели, инновационные стартапы и высокотехнологичные предприятия; студенты, аспиранты, профессорско-преподавательский состав высшей школы; аудиторы, консультанты, маркетологи, медиаторы, оценщики, патентоведы, страховые и судебные эксперты, экономисты, юристы.\n" +
                    "\n" +
                    "Две команды: работники (создатели РИД) и администрация работодателя (инвестор) или модератор.\n" +
                    "\n" +
                    "Цель: снизить риски конфликта интересов по имущественным интеллектуальным правам и повысить эффективность инноваций, стабильность предпринимательской деятельности, трудовых коллективов.\n" +
                    "\n" +
                    "Задачи:\n" +
                    "\n" +
                    "— познакомиться с возможным конфликтом интересов и репутационными потерями;\n" +
                    "— сформулировать возможные риски конфликта интересов и правонарушений;\n" +
                    "— найти приемлемые решения профилактики конфликта интересов и упущенной выгоды;\n" +
                    "— экспертиза решений и медиация конфликта интересов без репутационных потерь;\n" +
                    "— повышение профессиональной компетентности авторов, правопреемников; правообладателей.\n" +
                    "\n" +
                    "Конфликт интересов — имущественные права на: базу данных; диссертацию; методику; монографию; мультимедийную презентацию; ноу-хау (секреты производства); отчет НИОКР или РНТД; пользовательский интерфейс; программу для ЭВМ; проект (дипломный, инновационный); промышленный дизайн; регламент; рецептуру; спецификацию; стандарт; сценарий; техническое задание; техническое решение; технологию; учебное или методическое пособие; учебную программу.\n" +
                    "\n" +
                    "P.S. Комментарий игропрактики приложен. Также целесообразно познакомиться с комментарием игропрактики «Авторское свидетельство» (https://leader-id.ru/events/206928); подписаться на методическое обеспечение «Департамента коммуникаций IPM» (https://clubipm.wordpress.com).",
                "Россия, Москва, Москва, Малый Конюшковский Пер., д. 2 (3 этаж)",
                "finas@live.ru",
                "https://leader-id.ru/events/210215"
            ),
            EventResponse(
                "0d6b89e595e94656bca6f7909d0460ed",
                "Международный конфекс «Ингредиенты и добавки»",
                "В 2021 году конфекс «Ингредиенты и добавки» пройдет впервые. Площадкой проведения станет Технопарк «Сколково»...",
                "мероприятие",
                1629763200000,
                1629936000000,
                "О конфексе «Ингредиенты и добавки»:\n" +
                    "\n" +
                    "Конфекс (конференция + экспозиция) - особый формат деловых мероприятий, совмещающий ключевые особенности выставки и конференции - широкий выбор необходимой для решения бизнес-задач продукции, а также обилие профессиональной информации, без которой невозможно успешно развивать свой бизнес.\n" +
                    "\n" +
                    "В 2021 году конфекс «Ингредиенты и добавки» пройдет впервые. Площадкой проведения станет Технопарк «Сколково» – современный комплекс, ключевой центр развития инновационных технологий в России.\n" +
                    "\n" +
                    "Тематика мероприятия: ингредиенты и добавки, используемые при производстве:\n" +
                    "\n" +
                    "продуктов питания\n" +
                    "фармацевтической продукции\n" +
                    "косметики\n" +
                    "парфюмерии\n" +
                    "бытовой химии",
                "Большой бульвар, д. 42, корпус 1, Технопарк \"Сколково\"",
                "admin@mail.ru",
                "https://new.ingred.ru/ru-RU/"
            ),
            EventResponse(
                "e775dc0e047548fcb39ac19b1a010179",
                "Навстречу импакт-инвестициям. Модуль 5",
                "Навстречу импакт-инвестициям - первая в России программа, которая готовит социальных предпринимателей...",
                "выставка",
                1629331200000,
                1629504000000,
                "Навстречу импакт-инвестициям - первая в России программа, которая готовит социальных предпринимателей к привлечению импакт-инвестиций.\n" +
                    "\n" +
                    "Сайт программы - http://investimpact.ru\n" +
                    "\n" +
                    "Программа длится шесть месяцев с мая по ноябрь и включает в себя:\n" +
                    "\n" +
                    "● Программу обучения\n" +
                    "\n" +
                    "● Менторское сопровождение\n" +
                    "\n" +
                    "● Подготовку к привлечению импакт-инвестиций (разработку бизнес-плана и презентации)\n" +
                    "\n" +
                    "● Нетворкинг с импакт-инвесторами\n" +
                    "\n" +
                    "Результат участия в программе - готовый бизнес-план и презентация для инвестора. В случае успешной презентации, участник выходит на стадию переговоров с инвестором, которая может завершиться сделкой.\n" +
                    "\n" +
                    "Программа обучения состоится из шесте модулей, четыре из которых очные.",
                "Россия, Москва, Москва, Малый Конюшковский Пер., д. 2 (3 этаж)",
                "admin@mail.ru",
                "https://leader-id.ru/events/208159"
            ),
            EventResponse(
                "585d603f76af44d6ac950b9e2233e51d",
                "VR-лекции: «Как виртуальная реальность изменила мир»",
                "Интерактивные лекции для знакомства с технологиями виртуальной и дополненной реальности (VR/AR). Лекции...",
                "мероприятие",
                1628812800000,
                null,
                "Интерактивные лекции для знакомства с технологиями виртуальной и дополненной реальности (VR/AR). Лекции сопровождаются демонстрацией разнообразного авторского контента в формате 360, а также показами документального видео в обычных форматах.",
                "ЦИФРОВОЕ ДЕЛОВОЕ ПРОСТРАНСТВО МОСКВА, ПОКРОВКА, 47",
                "admin@mail.ru",
                "https://leader-id.ru/events/208159"
            ),
            EventResponse(
                "2131c9092eb04b2c8259b23961c06043",
                "Al-Bassel Exhibition: Syria, Damascus 28 Aug to 2 Sep 2021",
                "Al-Bassel Exhibition for Creativity and Invention is held in conjunction with the...",
                "выставка",
                1627776000000,
                null,
                "Al-Bassel Exhibition 2021\n" +
                    "Al-Bassel Exhibition for Creativity and Invention is held in conjunction with the sixty-second session of the Damascus International Fair from 28 August to 2 September 2021.\n" +
                    "\n" +
                    "Exhibition Aims\n" +
                    "Al-Bassel Exhibition for Creativity and Invention, a true embodiment of the directives of the immortal leader Hafiz Al-Assad and an expression of the hopes of the nation’s martyr, Basil Hafez Al-Assad.\n" +
                    "Embodiment of the slogan of self-reliance as a national position.\n" +
                    "Encouraging creative people, inventors and innovators to continue their scientific trends and develop their creativity.\n" +
                    "Maximum utilization of these inventions and putting them into practice in order to develop the base building.\n" +
                    "Capital investment and benefiting from it in following up the national innovation process.\n" +
                    "Providing a suitable general environment for the individual and public initiative and securing its material and human requirements.\n" +
                    "Taking care of creators and inventors and protecting their inventions, making them public and developing them.\n" +
                    "Getting acquainted with inventors locally and in the Arab world, benefiting from each other’s experiences, and strengthening relationships within the framework of creativity and invention with brotherly and friendly countries.\n" +
                    "The exhibition is a mirror of the achievements of the people of the nation on a creative vision and the heritage and civilization of our nation.\n",
                "Opposite Ibn Al-Nafees Hospital, Damascus, Syria  /online",
                "admin@mail.ru",
                "https://leader-id.ru/events/208159"
            )
        )
    }

    override fun getArchivedEvents(): List<EventResponse> {
        return listOf(
            EventResponse(
                "ee12fc8cfaca4d749df2eb75adfcd753",
                "\"Организационное поведение и лидерство\" от бизнес-школы МИРБИС",
                "Курс будет полезен руководителям среднего и высшего звена, поскольку позволит осознать особенности работы и поможет каждому участн ...",
                "лекция",
                1621900800000,
                1621987200000,
                "Раздел 1. Введение в организационное поведение.\n" +
                    "\n" +
                    "Понятие организационного поведения. Факторы, влияющие на организационное поведение. \n" +
                    "Значимость изучения дисциплины «Организационное  поведение» в практической  работе руководителей. \n" +
                    "Поведение в организации как система и ее основные элементы. Личность, группа и организация – содержание понятий и их взаимосвязь. Критерии оценки эффективности деятельности на уровне индивидуума, группы и  организации.\n" +
                    "\n" +
                    "Раздел 2. Личность в организации. \n" +
                    "\n" +
                    "Тема 1. Индивидуальные отличия людей в процессе трудовой деятельности, типы личности. Установка личности в организационном поведении. \n" +
                    "\n" +
                    "Тема 2. Мотивация трудовой деятельности и результативность.\n" +
                    "Мотивация и выполнение работы; основные подходы к мотивации. Стратегии мотивации.  Материальное и моральное вознаграждение.\n" +
                    "Удовлетворенность трудом и преданность организации. Факторы, влияющие на удовлетворенность трудом. \n" +
                    "\n" +
                    "Раздел 3. Групповая эффективность.\n" +
                    "\n" +
                    "Тема 1. Группы в организации: виды, групповая динамика, групповые процессы. Команда.\n" +
                    "Виды групп: формальные и неформальные рабочие группы. Развитие группы, процессы групповой динамики. \n" +
                    "Влияние группы на индивидуальное поведение; групповые процессы: социальная леность, деиндивидуализм, социальная фасилитация; групповая поляризация; огруппление мышления, влияние меньшинства; групповая сплоченность; нормы в организационных группах; влияние группы на поведение и установки работников; социально-психологический климат в коллективе. \n" +
                    "Понятие «команды». Команда, ее отличие от рабочей группы. Достоинства и перспективы развития командных форм организации труда. Принципы создания команды;  основные сферы деятельности команды; формы управления в команде; недостатки команды; профилактика распада команды; основные типы распределения функций в команде.\n" +
                    " \n" +
                    "Тема 2. Руководство и лидерство.\n" +
                    "Понятие руководства и лидерства;  соотношение руководства и лидерства в системе управления; влияние лидерства на успехи организации.\n" +
                    "Стили лидерства, зависимость стиля лидерства от ситуации, типы лидеров; условия лидерства; психологические проблемы руководства и лидерства, возникающие при выполнении основных функций управления.\n" +
                    "Современные требования к руководителям. \n" +
                    " \n" +
                    "Тема 3. Особенности общения в группе. Конфликты.\n" +
                    "Общение в группе: вербальное и невербальное. Конфликты. Виды конфликтов. Конфликт между личностью и группой. Ролевой конфликт. Межгрупповой конфликт и его причины. Стадии развития конфликта – их характеристика. \n" +
                    "Методы управления и профилактики межгрупповых конфликтов. Стиля поведения в конфликте.\n" +
                    "\n" +
                    "Раздел 4. Организационная эффективность.\n" +
                    "Понятие организационной культуры. Уровни организационной культуры. Функции организационной культуры. \n" +
                    "Процесс формирования организационной культуры компании. Основные элементы организационной культуры компании. Национальные особенности в организационной культуре. \n" +
                    "Влияние организационной культуры на производительность, удовлетворенность работой, дисциплину и текучесть.",
                "Москва | Москва, улица Марксистская, 34к7",
                "mba@mirbis.ru",
                "https://mirbis-mba.timepad.ru/event/1442732/"
            ),
            EventResponse(
                "ca6fda2b463140b1860e88e867efc1cf",
                "SVIIF: Santa Clara, California 10-12 June 2021",
                "SVIIF works to publicize state-of-the-art inventions around the world and provides " +
                    "a unique opportunity for inventors to not only commercialize their inventions but also the American market in the heart of the Silicon Valley ....",
                "Выставка",
                1622505600000,
                null,
                "SVIIF works to publicize state-of-the-art inventions around the world and provides a unique opportunity " +
                    "for inventors to not only commercialize their inventions but also the American market in the heart of the Silicon Valley.\n" +
                    "\n" +
                    "As a participant in the Silicon Valley International Invention Festival" +
                    ", you benefit from the most extensive support, privileges, and resources that can be granted to an exhibition. " +
                    "SVIIF is under the patronage of the City of Santa Clara, the International Federation of Inventors Associations – " +
                    "IFIA, the Geneva Invention Exhibition, the Palexpo and of the World Intellectual Property Organization – WIPO.",
                "ONLINE",
                "admin@mail.ru",
                "https://www.ifia.com/mobile_event/sviif/"
            )
        )
    }


}