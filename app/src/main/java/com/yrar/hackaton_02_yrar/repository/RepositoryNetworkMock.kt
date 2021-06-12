package com.yrar.hackaton_02_yrar.repository

import com.yrar.hackaton_02_yrar.model.network.EventResponse
import com.yrar.hackaton_02_yrar.retrofit.API

class RepositoryNetworkMock(val service: API): RepositoryNetwork {
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
                "выставка",
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