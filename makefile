# Honor Pledge:
#
#I pledge that I have neither given nor
#received any help on this assignment.
#
#jwaggon

all: Driver Employee PharmacyManager StaffPharmacist StaffTechnician SeniorTechnician

Driver: Driver.java
	javac Driver.java
Employee: Employee.java
	javac Employee.java
PharmacyManager: PharmacyManager.java
	javac PharmacyManager.java
StaffPharmacist: StaffPharmacist.java
	javac StaffPharmacist.java
StaffTechnician: StaffTechnician.java
	javac StaffTechnician.java
SeniorTechnician: SeniorTechnician.java
	javac SeniorTechnician.java
clean:
	rm *.class
