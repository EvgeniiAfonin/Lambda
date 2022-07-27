import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.*;


public class UsersTests {

    UserInfo userInfoNumberOne = new UserInfo("Joha", 35, 87, true, "QA");
    UserInfo userInfoNumberTwo = new UserInfo("Petro", 23, 55, true, "BA");
    UserInfo userInfoNumberThree = new UserInfo("Sahko", 18, 63, true, "Designer");
    UserInfo userInfoNumberFour = new UserInfo("Ira", 25, 39, false, "PM");
    UserInfo userInfoNumberFive = new UserInfo("Galya", 53, 78, false, "PO");
    UserInfo userInfoNumberSix = new UserInfo("Olya", 37, 67, false, "CTO");
    UserInfo userInfoNumberSeven = new UserInfo("Polina", 28, 93, false, "QA");
    UserInfo userInfoNumberEight = new UserInfo("Vova", 35, 120, true, "BackEnd");
    UserInfo userInfoNumberNine = new UserInfo("Kostya", 26, 98, true, "BA");
    UserInfo userInfoNumberTen = new UserInfo("Kolya", 39, 112, true, "SA");
    UserInfo userInfoNumberEleven = new UserInfo("Andriy", 24, 76, true, "SA");
    UserInfo userInfoNumberTwelve = new UserInfo("Natali", 17, 87, false, "FrontEnd");
    UserInfo userInfoNumberThirteen = new UserInfo("Nastya", 32, 69, false, "BackEnd");
    UserInfo userInfoNumberFourteen = new UserInfo("Katya", 21, 95, false, "FrontEnd");
    UserInfo userInfoNumberFifteen = new UserInfo("Stas", 27, 89, true, "BackEnd");

    List<UserInfo> userInfoList = Arrays.asList(userInfoNumberOne, userInfoNumberTwo, userInfoNumberThree, userInfoNumberFour, userInfoNumberFive,
            userInfoNumberSix, userInfoNumberSeven, userInfoNumberEight, userInfoNumberNine, userInfoNumberTen, userInfoNumberEleven,
            userInfoNumberTwelve, userInfoNumberThirteen, userInfoNumberFourteen, userInfoNumberFifteen);


    @Test
    public void filteringUsersByName() {
        List<UserInfo> result = UserFilter.filter(userInfoList, new UserFilter() {
            @Override
            public boolean isFiltered(UserInfo userData) {
                return userData.getName().equals("Kolya");
            }
        });

        for (UserInfo userInfo : result) {
            assertThat(userInfo.getName()).contains("Kolya");
            System.out.println(userInfo);
        }
    }


    @Test
    public void filteringUsersByAge() {
        List<UserInfo> result = UserFilter.filter(userInfoList, new UserFilter() {
            @Override
            public boolean isFiltered(UserInfo userData) {
                return userData.getAge() == 41;
            }
        });

        for (UserInfo userInfo : result) {
            assertThat(userInfo.getAge()).isEqualTo(41);
            System.out.println(userInfo);
        }
    }

    @Test
    public void filteringUsersByWeight() {
        List<UserInfo> result = UserFilter.filter(userInfoList, new UserFilter() {
            @Override
            public boolean isFiltered(UserInfo userData) {
                return userData.getWeight() == 76;
            }
        });
        for(UserInfo userInfo : result) {
            assertThat(userInfo.getWeight()).isEqualTo(76);
            System.out.println(userInfo);
        }
    }

    @Test
    public void filteringUsersBySex() {
        List<UserInfo> result = UserFilter.filter(userInfoList, new UserFilter() {
            @Override
            public boolean isFiltered(UserInfo userData) {
                return userData.isSex();
            }
        });
        for(UserInfo userInfo : result) {
            assertThat(userInfo.isSex()).isTrue();
            System.out.println(userInfo);
        }
    }

    @Test
    public void filteringUsersBySpeciality() {
        List<UserInfo> result = UserFilter.filter(userInfoList, new UserFilter() {
            @Override
            public boolean isFiltered(UserInfo userData) {
                return userData.getSpeciality().equals("QA");
            }
        });
        for(UserInfo userInfo : result) {
            assertThat(userInfo.getSpeciality()).contains("QA");
            System.out.println(userInfo);
        }
    }

    @Test
    public void filteringUsersByAllInfo() {
        List<UserInfo> result = UserFilter.filter(userInfoList, new UserFilter() {
            @Override
            public boolean isFiltered(UserInfo userData) {
                return userData.getName().equals("Joha") && userData.getAge() == 35 && userData.getWeight() == 87 &&
                        userData.isSex() && userData.getSpeciality().equals("QA");
            }
        });
        for(UserInfo userInfo : result) {
            assertThat(userInfo.getName()).contains("Joha");
            assertThat(userInfo.getAge()).isEqualTo(35);
            assertThat(userInfo.getWeight()).isEqualTo(87);
            assertThat(userInfo.isSex()).isTrue();
            assertThat(userInfo.getSpeciality()).contains("QA");
            System.out.println(userInfo);
        }
    }

    @Test
    public void filteringUsersByMostOlderPerson() {
        List<UserInfo> result = UserFilter.filter(userInfoList, new UserFilter() {
            @Override
            public boolean isFiltered(UserInfo userData) {
                return userData.getAge() > 45;
            }
        });

        for (UserInfo userInfo : result) {
            assertThat(userInfo.getAge()).isEqualTo(53);
            System.out.println(userInfo);
        }
    }

    @Test
    public void filteringUsersByMostYoungPerson() {
        List<UserInfo> result = UserFilter.filter(userInfoList, new UserFilter() {
            @Override
            public boolean isFiltered(UserInfo userData) {
                return userData.getAge() < 18;
            }
        });

        for (UserInfo userInfo : result) {
            assertThat(userInfo.getAge()).isEqualTo(17);
            System.out.println(userInfo);
        }
    }

    @Test
    public void filteringUsersByMostBigPersonFromMan() {
        List<UserInfo> result = UserFilter.filter(userInfoList, new UserFilter() {
            @Override
            public boolean isFiltered(UserInfo userData) {
                return userData.getWeight() >= 120 && userData.isSex();
            }
        });

        for (UserInfo userInfo : result) {
            assertThat(userInfo.getWeight()).isEqualTo(120);
            assertThat(userInfo.isSex()).isTrue();
            System.out.println(userInfo);
        }
    }

    @Test
    public void filteringUsersByYoungWomenButHasOverweight() {
        List<UserInfo> result = UserFilter.filter(userInfoList, new UserFilter() {
            @Override
            public boolean isFiltered(UserInfo userData) {
                return userData.getAge() == 21 && userData.getWeight() > 90 ;
            }
        });

        for (UserInfo userInfo : result) {
            assertThat(userInfo.getAge()).isEqualTo(21);
            assertThat(userInfo.getWeight()).isEqualTo(95);
            System.out.println(userInfo);
        }
    }

}
