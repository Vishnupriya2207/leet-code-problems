lass DiningPhilosophers {

    private Semaphore[] forks;
    private Semaphore room;

    public DiningPhilosophers() {
        forks = new Semaphore[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }

        // Allow only 4 philosophers to try eating at once
        room = new Semaphore(4);
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher + 1) % 5;

        room.acquire();

        forks[left].acquire();
        forks[right].acquire();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putRightFork.run();
        forks[right].release();

        putLeftFork.run();
        forks[left].release();

        room.release();
    }
}
