<!DOCTYPE html>
<html>
<head>
    <title>Electricity Data Entry</title>
    
</head>

<body style="background-color: lightgrey ;">
    <h2>Housing Information</h2>
    <form action="SubmitData" method="post">
        <label for="selectArea">Select Area</label>   
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 
        <label for="selectCategory">Select Category</label> <br>
        <input type="number" id="selectArea" name="selectArea" required>  &nbsp; &nbsp;  
        <input type="number" id="selectCategory" name="selectCategory" required><br><br>
        
        
        <label for="nameofHousing/institution/school/office">name of Housing/institution/school/office</label>
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp;
        <label for="numberofHouseHolds">Number Of HouseHolds</label> <br>
        <input type="number" id="nameOfHousing/instituion/school/office" name="nameofHousing/instituion/school/office" required> &nbsp; &nbsp;
        <input type="number" id="NumberOfHouseHolds" name="Number OF HouseHolds" required><br><br>

      <label for="fullAddress">Full Address</label><br>
      <input type="number" id="line1" name="Full Address" required>
      <input type="number" id="line2" name="Full Address" required>
      
        
        <button type="submit">Upload</button><br><br>
    </form>
      
</body>
</html>