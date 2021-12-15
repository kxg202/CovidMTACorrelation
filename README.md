# CovidMTACorrelation
This is a repository containing code that calculates the correlation between COVID-19 and MTA transportation ridership.

The ProfileCovidFirstMonthOnly.java, ProfileCovidFirstMonthOnlyMapper.java, and ProfileCovidFirstMonthOnlyReducer.java files are used to extract the rows whose dates fall between 3/1/20 and 4/1/20 from the COVID-19 cases dataset using the date library in Java. 

The CovidAll.java, CovidAllMapper.java, and CovidAllReducer.java files are used to extract the whole COVID-19 cases dataset starting from 3/1/2020.

The ProfileCovidAll.java, ProfileCovidAllMapper.java, and ProfileCovidAllReducer.java files are used to determine the maximum case count from the COVID-19 cases dataset.

The MaximumRidershipMapper.java, MaximumRidership.java, and MaximumRidershipReducer.java files are used to determine the maximum ridership value in the MTA ridership dataset for both subways and buses.

The NormalizeCovidAll.java, NormalizeCovidAllMapper.java, and NormalizeCovidAllReducer.java files are used to normalize the COVID-19 case counts dataset based on the maximum case count which was determined earlier using the ProfileCovidAll.java, ProfileCovidAllMapper.java, and ProfileCovidAllReducer.java files.

The NormalizeMapper.java, Normalize.java, and NormalizeReducer.java files are used to normalize the MTA dataset based on the maximum ridership determined earlier using the MaximumRidershipMapper.java, MaximumRidership.java, and MaximumRidershipReducer.java files.

The PartitionFirstMonth.java, PartitionFirstMonthMapper.java, and PartitionFirstMonthReducer.java files are used to extract the rows from the MTA ridership dataset whose dates fall between 3/1/20 and 4/1/20. The PartitionAll.java, PartitionAllMapper.java, and PartitionAllReducer.java files are used to extract the rows from the MTA ridership dataset whose dates fall between 3/1/20 and 10/19/21.

The Scala_Commands_1stMonth.txt file contains Scala commands that are used in Spark to calculate the Pearson correlation between COVID-19 case counts and subway and bus ridership for the 1st month only (3/1/20–4/1/20). The Scala_Commands_All.txt file contains Scala commands that are used in Spark to calculate the Pearson correlation between COVID-19 case counts and subway and bus ridership for the whole duration of the outbreak.
