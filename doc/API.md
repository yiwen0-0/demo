#API ENDPOINTS

##Household CRUD
<table>
<thead>
    <td>
       Action
    </td>
    <td>
       Description
    </td>
    <td>
       Input Format
    </td>
    <td>
       Response Format
    </td>
</thead>
<tr>
<td>POST api/households</td>
<td>Adding a household</td>
<td>

```yaml
{
   "housingType": HousingType
}
```
</td>
<td>

```yaml
{
  "id": Long,
  "housingType": HousingType,
  "familyMembers": [
    [{
      "id": Long,
      "name": String,
      "gender": Gender,
      "maritalStatus": MaritalStatus,
      "occupationType": OccupationType,
      "spouse": Long,
      "annualIncome": Long,
      "dateOfBirth": "YYYY-MM-DD",
      "householdId": Long,
    },...]
  ],
  "totalHouseholdIncome": Long,
}
```
</td>
</tr>
<tr>
<td>GET api/households</td>
<td>Listing all households</td>
<td>

</td>
<td>

```yaml
[
{
  "id": Long,
  "housingType": HousingType,
  "familyMembers": [],
  "totalHouseholdIncome": Long,
},...]
```
</td>
</tr>
<tr>
<td>DELETE api/households/{id}</td>
<td>Remove household and its associative family members</td>
<td>

</td>
<td>

</td>
</tr>
</table>

##People CRUD
<table>
<thead>
    <td>
       Action
    </td>
    <td>
       Description
    </td>
    <td>
       Input Format
    </td>
    <td>
       Response Format
    </td>
</thead>
<tr>
<td>POST api/people</td>
<td>Adding a person</td>
<td>

```yaml
{
  "name": String,
  "gender": Gender,
  "maritalStatus": MaritalStatus,
  "occupationType": OccupationType,
  "spouse": Long,
  "annualIncome": Long,
  "dateOfBirth": "YYYY-MM-DD",
  "householdId": Long,
}
```
</td>
<td>

```yaml
{
  "id": Long,
  "name": String,
  "gender": Gender,
  "maritalStatus": MaritalStatus,
  "occupationType": OccupationType,
  "spouse": Long,
  "annualIncome": Long,
  "dateOfBirth": "YYYY-MM-DD",
  "householdId": Long,
}
```
</td>
</tr>
<tr>
<td>GET api/people</td>
<td>Listing all people</td>
<td>

</td>
<td>

```yaml
[{
  "id": Long,
  "name": String,
  "gender": Gender,
  "maritalStatus": MaritalStatus,
  "occupationType": OccupationType,
  "spouse": Long,
  "annualIncome": Long,
  "dateOfBirth": "YYYY-MM-DD",
  "householdId": Long,
},...]
```
</td>
</tr>
<tr>
<td>PUT api/people</td>
<td>Update the details of a person</td>
<td>

```yaml
{
  "id": Long,
  "name": String,
  "gender": Gender,
  "maritalStatus": MaritalStatus,
  "occupationType": OccupationType,
  "spouse": Long,
  "annualIncome": Long,
  "dateOfBirth": "YYYY-MM-DD",
  "householdId": Long,
}
```
</td>
<td>

```yaml
{
  "id": Long,
  "name": String,
  "gender": Gender,
  "maritalStatus": MaritalStatus,
  "occupationType": OccupationType,
  "spouse": Long,
  "annualIncome": Long,
  "dateOfBirth": "YYYY-MM-DD",
  "householdId": Long,
}
```
</td>
</tr>

<tr>
<td>DELETE api/people/{id}</td>
<td>Remove a person</td>
<td>
</td>
<td>
</td>
</tr>
</table>

##Grant Recipient Search
<table>
<thead>
    <td>
       Action
    </td>
    <td>
       Description
    </td>
    <td>
       Input Format
    </td>
    <td>
       Response Format
    </td>
</thead>
<tr>
<td>
GET api/households/grant/type={GrantType}&householdSize={Integer}&totalIncome={Long}
<br /><br />
<b>householdSize and totalIncome are optional parameters</b>
</td>
<td>Searching for households and recipients of a certain {GrantType} with household size <= {householdSize}
and total household income <= {totalIncome}</td>
<td>
For GrantType, refer to corresponding code in

[Grant Type Code Table](CodeTable.md)

</td>
<td>

```yaml
{
  "id": Long,
  "housingType": HousingType,
  "familyMembers": [
    [{
      "id": Long,
      "name": String,
      "gender": Gender,
      "maritalStatus": MaritalStatus,
      "occupationType": OccupationType,
      "spouse": Long,
      "annualIncome": Long,
      "dateOfBirth": "YYYY-MM-DD",
      "householdId": Long,
    },...]                    
  ],
  "totalHouseholdIncome": Long,
}
```
</td>
</tr>
</table>