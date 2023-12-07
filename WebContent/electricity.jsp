<!DOCTYPE html>
<html>
<head>
    <title>Electricity Data Entry</title>
    
</head>

<body style="background-color: lightgrey ;">
    <h2>Electricity Consumption</h2>
    <form action="SubmitData" method="post">
        <label for="totalDays">Total Days</label>   
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 
        <label for="prorateFactor">Prorate Factor</label> <br>
        <input type="number" id="totalDays" name="totalDays" required>  &nbsp; &nbsp;  
        <input type="number" id="prorateFactor" name="prorateFactor" required><br><br>
        
        
        <label for="currentUsage">Current Usage</label>
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp;
        <label for="currentAmount">Current Amount</label> <br>
        <input type="number" id="currentUsage" name="CurrentUsage" required> &nbsp; &nbsp;
        <input type="number" id="currentAmount" name="currentAmount" required><br><br>

  
      <label for="billProof">Bill Proof</label><br>
      <input type="file"id="fileInput" name="billProof" style="height: 80px; width: 40%;" required><br><br>
        
        
        <label for="description">Describe how you saved electricity in details:</label><br>
        <textarea id="description" name="description" rows="6" cols="50" required></textarea><br><br>
        
        <button type="submit">Upload</button><br><br>
    </form>
      
</body>
</html>