# About the challenge

This challenge was to develop a fictional API for a programming course company that uses CRUD to create courses.

## Requirements

#### The API should provide the following functionality
- Create a new course
- List all courses
- Update a course by `id
- Removing a course by `id`.

### Routes and Business Rules

Before we talk about routes, let's understand what structure (properties) a task should have:

- `id` - unique identifier for each course
- `name` - name of the course
- `category` - course category
- `active` - whether the course is active or not
- `created_at` - Date when the course was created
- `updated_at` - Should always be changed to the date when the course was updated.

### Routes:
- `POST - /courses`

    It should be possible to create a course in the database by sending the `name` and `category` fields in the `body` of the request.
    
    When creating a course, the fields: `id`, `created_at` and `updated_at` should be filled in automatically, as specified by the properties above.

- `GET - /courses`
    
    It should be possible to list all courses stored in the database.
    
    It should also be possible to do a search, filtering the courses by `name` and `category`.
    
- `PUT - /courses/:id`
    
    It must be possible to update a course by its `id`.
    
    In the `body` of the request, only the `name` and/or `category` should be sent to be updated.
    
    If only the `name` is sent, it means that the `category` cannot be updated and vice versa. In addition, if `active` is sent on this route, it should be ignored because the route that should do this update is the patch route.

- `DELETE - /courses/:id`
    
    It should be possible to delete a course using its `id'.
    
- `PATCH - /courses/:id/active`
    
    This pathname will mark if the course is active or not, i.e. a toggle between true or false.
