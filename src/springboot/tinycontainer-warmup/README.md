# TinyContainer Warmup (Framework Mental Model)

This project is a **pure Java** warmup to help you understand how a framework like Spring works.

## What you will observe
When you run the app, the output will clearly show:

1. **Registration phase**: what the container knows how to build (definitions)
2. **Creation + wiring phase**: how constructor dependencies are resolved and injected
3. **Init phase**: how lifecycle init methods are called (our minimal lifecycle demo)
4. **Startup phase**: how the framework calls your code after everything is ready
5. **Report phase**: what objects exist inside the container after startup

## How to run

### Option A: Terminal

```bash
cd tinycontainer-warmup
./run.sh
```

### Option B: IntelliJ
- Open the project folder.
- Run `com.guvi.module4.student.main.AppMain`.

## Feature request (student task)
Add **Find student by email** end-to-end:
- Update `StudentRepository`
- Implement in `InMemoryStudentRepository`
- Expose a method in `StudentService`
- Call it in `DemoStartup` and print the result

Keep the focus: **interface change + repo change + service change**.
