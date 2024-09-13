# General
This is the backend implementation for project written during my work on a full-stack Angular course. The code serves the projects written during that course (https://github.com/GNahary/fsa-members-only, https://github.com/GNahary/fsa-meal-tracker).
To set the project up, you'll need to have a running MongoDB (I'm currently using MongoDB Compass version 1.43.6).

# Setup

## Meal Tracker
The necessary entities for the Meal Tracker project are as follows:

A collection named "meal-tracker-ingredients" holding users with the following structure:
{
  "name": "[Ingredient Name]",
  "amount": X, // number of units
  "units": "XXX" // Unit (No validation or enums here, go wild)
}


A collection named "meal-tracker-recipes" holding users with the following structure:
{
  "id": "XXXX", // Custom Id
  "name": "XXXX", // Name of recipe
  "ingredients": [
    {
      "name": "XXXX", // Name
      "amount": XXXX, // Amount
      "units": "XXX" // Unit (No validation or enums here, go wild)
    },
    ....
  ],
  "originalRecipeLink": "XXXXX" // link to recipe
}


A collection named "meal-tracker-ingredients" holding users with the following structure:
{
  "recipeId": "XXXX", // Custom id of the recipe
  "plannedDate": {
    "$date": "yyyy-MM-DDThh:mm:ss.000Z" // Planned date with the shown format
  }
}


## Members Only
The necessary entities for the Members Only project are as follows:

A collection named "members-only-users" holding users with the following structure:

{
  "id": "XXXXX", // the id that was given for the user in Firebase, see relevant project.
  "email": "XXXX", // email for the user
  "fullName": "XXXX" // full name of the user.
}

A collection named "members-only-requests" holding users with the following structure:

{
  "id": "345",
  "userId": "XXXX", // Id correspond to the user id in the users collection
  "groupId": "XXXXX" // A group Id corresponds to the Mongo generated group id, as described in the groups collection
}


A collection named "members-only-groups" holding users with the following structure:
{
  "name": "XXXX", // Name of the group
  "ownerId": "XXXX",// Id correspond the the user id in the users collection
  "members": ["XXXX", "XXXX"] // Ids correspond to user ids in the users collection
}


A collection named "members-only-messages" holding users with the following structure:
{
  "userId": "XXXXX", // Id correspond the the user id in the users collection
  "groupId": "XXXXXXX", // A group Id corresponds to the Mongo generated group id, as described in the groups collection
  "text": "XXXXX" // Your text
}

Note that for each group the owner should also appear in the members list.
There is no validation in the code preventing several requests to join from the same user, as well as no validation meant to prevent a member from submitting a request to join the group he's a member of (this isn't supported through UI, but the program won't fail if you'll instert it in the DB).
