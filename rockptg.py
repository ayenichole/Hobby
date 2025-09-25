import sys
from time import sleep

def printLyrics():
    lines = [
        ("I wanna da-", 0.06),
        ("I wanna dance in the lights", 0.05),
        ("I wanna ro-", 0.07),
        ("I wanna rock your body", 0.08),
        ("I wanna go", 0.08),
        ("I wanna go for a ride", 0.068),
        ("Hop in the music and", 0.07),
        ("Rock your body", 0.08),
        ("Rock that body", 0.069),
        ("come on, come on", 0.035),
        ("Rock that body", 0.05),
        ("(Rock your body)", 0.03),
        ("Rock that body", 0.049),
        ("come on, come on", 0.035),
        ("Rock that body", 0.08),
    ]

    delays = [0.2, 1, 0.2, 1, 0.2, 0.8, 0.2, 0.5, 0.18, 0.1, 0.15, 0.3, 0.3, 0.1, 5]

    for i, (line, char_delay) in enumerate(lines):
        for char in line:
            # Add a simple ANSI color: yellow for normal, cyan for "(Rock your body)"
            if line == "(Rock your body)":
                sys.stdout.write(f"\033[36m{char}\033[0m")  # cyan
            else:
                sys.stdout.write(f"\033[33m{char}\033[0m")  # yellow
            sys.stdout.flush()
            sleep(char_delay)
        print()  # newline after each line
        sleep(delays[i])

printLyrics()
